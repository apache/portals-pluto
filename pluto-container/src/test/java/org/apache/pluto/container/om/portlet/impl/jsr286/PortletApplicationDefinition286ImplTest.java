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


package org.apache.pluto.container.om.portlet.impl.jsr286;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.pluto.container.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.EventDefinition;
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.PublicRenderParameter;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserAttribute;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.ContainerRuntimeOptionImpl;
import org.apache.pluto.container.om.portlet.impl.CustomPortletModeImpl;
import org.apache.pluto.container.om.portlet.impl.CustomWindowStateImpl;
import org.apache.pluto.container.om.portlet.impl.EventDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.FilterImpl;
import org.apache.pluto.container.om.portlet.impl.FilterMappingImpl;
import org.apache.pluto.container.om.portlet.impl.ListenerImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PortletDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.PublicRenderParameterImpl;
import org.apache.pluto.container.om.portlet.impl.SecurityConstraintImpl;
import org.apache.pluto.container.om.portlet.impl.UserAttributeImpl;
import org.apache.pluto.container.om.portlet.impl.UserDataConstraintImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 168 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class PortletApplicationDefinition286ImplTest {

   private static final String  WEBDDPKG         = "org/apache/pluto/container/om/portlet/";
   private static final String  WEBDD31          = "webApp31simple.xml";

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet286Generated.xml";
   
   private static PortletApplicationDefinition pad;
   private static ConfigurationHolder cfp;
   
   // class under test; cloned new for each test
   private  PortletApplicationDefinition cut;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = PortletApplicationDefinition286ImplTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);
      
      cfp = new ConfigurationHolder();
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
      cut = new PortletApplicationDefinitionImpl(pad);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getId()}.
    */
   @Test
   public void testGetSetId() {
      String val = cut.getId();
      assertNotNull(val);
      assertEquals("id1", val);
      cut.setId("42");
      val = cut.getId();
      assertNotNull(val);
      assertEquals("42", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getName()}.
    */
   @Test
   public void testGetSetName() {
      cut.setName("Bob");
      String val = cut.getName();
      assertNotNull(val);
      assertEquals("Bob", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getContextPath()}.
    */
   @Test
   public void testSetGetContextPath() {
      cut.setContextPath("Bob");
      String val = cut.getContextPath();
      assertNotNull(val);
      assertEquals("Bob", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getVersion()}.
    */
   @Test
   public void testGetSetVersion() {
      String val = cut.getVersion();
      assertNotNull(val);
      assertEquals("2.0", val);
      cut.setVersion("42");
      val = cut.getVersion();
      assertNotNull(val);
      assertEquals("42", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getResourceBundle()}.
    */
   @Test
   public void testGetSetResourceBundle() {
      String val = cut.getResourceBundle();
      String txt = "com.ibm.portal.ResourceBundle";
      assertNotNull(val);
      assertEquals("org.apache.pluto.container.om.portlet.GoodBundle", val);
      cut.setResourceBundle(txt);
      val = cut.getResourceBundle();
      assertNotNull(val);
      assertEquals(txt, val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getDefaultNamespace()}.
    */
   @Test
   public void testGetSetDefaultNamespace() {
      String val = cut.getDefaultNamespace();
      String txt = "https://www.ibm.com/";
      assertNotNull(val);
      assertEquals("https://www.apache.org/", val);
      cut.setDefaultNamespace(txt);
      val = cut.getDefaultNamespace();
      assertNotNull(val);
      assertEquals(txt, val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getPortlet(java.lang.String)}.
    */
   @Test
   public void testGetPortlet() {
      PortletDefinition pd = cut.getPortlet("portlet286");
      assertNotNull(pd);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getPortlets()}.
    */
   @Test
   public void testGetPortlets() {
      List<PortletDefinition> list = cut.getPortlets();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("portlet286", list.get(0).getPortletName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addPortlet(org.apache.pluto.container.om.portlet.PortletDefinition)}.
    */
   @Test
   public void testAddPortlet() {
      String newPN = "newPortlet";
      PortletDefinition pd = new PortletDefinitionImpl(newPN, cut);
      cut.addPortlet(pd);
      
      List<PortletDefinition> list = cut.getPortlets();
      assertNotNull(list);
      assertEquals(2, list.size());
      boolean ok = false;
      for (PortletDefinition item : list) {
         if (item.getPortletName().equals(newPN)) {
            ok = true;
         }
      }
      assertTrue(ok);
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
      QName qn = new QName("https://www.apache.org/", "supported-processing-event");
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
      QName qn = new QName("https://www.apache.org/", "supported-processing-event");
      EventDefinition item = cut.getEventDefinition(qn);
      assertNotNull(item);
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
      String prpid = "supported-public-render-parameter";
      PublicRenderParameter prp = cut.getPublicRenderParameter(prpid);
      assertNotNull(prp);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getPublicRenderParameters()}.
    */
   @Test
   public void testGetPublicRenderParameters() {
      String prpid = "supported-public-render-parameter";
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
      String newItem = "portlet-mode";
      CustomPortletMode item = cut.getCustomPortletMode(newItem);
      assertNotNull(item);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomPortletModes()}.
    */
   @Test
   public void testGetCustomPortletModes() {
      String newItem = "portlet-mode";
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getPortletMode());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addCustomPortletMode(org.apache.pluto.container.om.portlet.CustomPortletMode)}.
    */
   @Test
   public void testAddCustomPortletMode() {
      String newItem = "newMode";
      CustomPortletMode prp = new CustomPortletModeImpl(newItem);
      cut.addCustomPortletMode(prp);
      
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getPortletMode());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomWindowState(java.lang.String)}.
    */
   @Test
   public void testGetCustomWindowState() {
      String newItem = "window-state";
      CustomWindowState item = cut.getCustomWindowState(newItem);
      assertNotNull(item);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getCustomWindowStates()}.
    */
   @Test
   public void testGetCustomWindowStates() {
      String newItem = "window-state";
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getWindowState());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addCustomWindowState(org.apache.pluto.container.om.portlet.CustomWindowState)}.
    */
   @Test
   public void testAddCustomWindowState() {
      String newItem = "newMode";
      CustomWindowState prp = new CustomWindowStateImpl(newItem);
      cut.addCustomWindowState(prp);
      
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getWindowState());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttribute(java.lang.String)}.
    */
   @Test
   public void testGetUserAttribute() {
      String newItem = "name";
      UserAttribute item = cut.getUserAttribute(newItem);
      assertNotNull(item);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttributes()}.
    */
   @Test
   public void testGetUserAttributes() {
      String newItem = "name";
      List<UserAttribute> list = cut.getUserAttributes();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addUserAttribute(org.apache.pluto.container.om.portlet.UserAttribute)}.
    */
   @Test
   public void testAddUserAttribute() {
      String newItem = "newAttr";
      UserAttribute prp = new UserAttributeImpl(newItem);
      cut.addUserAttribute(prp);
      
      List<UserAttribute> list = cut.getUserAttributes();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilter(java.lang.String)}.
    */
   @Test
   public void testGetFilter() {
      String newItem = "filter-name";
      Filter item = cut.getFilter(newItem);
      assertNotNull(item);
      Filter filter = cut.getFilters().get(0);
      assertEquals("org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter", 
            filter.getFilterClass());
      assertEquals("description", filter.getDescription(new Locale("de")).getText());
      assertEquals("display-name", filter.getDisplayName(new Locale("de")).getText());
      assertEquals("lifecycle", filter.getLifecycles().get(0));
      assertEquals("value", filter.getInitParam("name").getParamValue());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilters()}.
    */
   @Test
   public void testGetFilters() {
      String newItem = "filter-name";
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void testAddFilter() {
      String newItem = "newFilter";
      String filCls = "org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass(filCls);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilterMapping(java.lang.String)}.
    */
   @Test
   public void testGetFilterMapping() {
      String newItem = "filter-name";
      FilterMapping item = cut.getFilterMapping(newItem);
      assertNotNull(item);
      assertEquals(1, item.getPortletNames().size());
      assertEquals("portlet286", item.getPortletNames().get(0));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilterMappings()}.
    */
   @Test
   public void testGetFilterMappings() {
      String newItem = "filter-name";
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilterMapping(org.apache.pluto.container.om.portlet.FilterMapping)}.
    */
   @Test
   public void testAddFilterMapping() {
      String newItem = "newFilter";
      FilterMapping fm = new FilterMappingImpl(newItem);
      fm.addPortletName("portlet286");
      cut.addFilterMapping(fm);
      
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOption(java.lang.String)}.
    */
   @Test
   public void testGetContainerRuntimeOption() {
      String newItem = "Runtime-Option-Portlet-App";
      ContainerRuntimeOption item = cut.getContainerRuntimeOption(newItem);
      assertNotNull(item);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOptions()}.
    */
   @Test
   public void testGetContainerRuntimeOptions() {
      String newItem = "Runtime-Option-Portlet-App";
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addContainerRuntimeOption(org.apache.pluto.container.om.portlet.ContainerRuntimeOption)}.
    */
   @Test
   public void testAddContainerRuntimeOption() {
      String newItem = "newRTO";
      String[] newvals = {"v1", "v2"}; 
      ContainerRuntimeOption item = new ContainerRuntimeOptionImpl(newItem, Arrays.asList(newvals));
      cut.addContainerRuntimeOption(item);
      
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getName());
      assertArrayEquals(newvals, list.get(1).getValues().toArray());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getListeners()}.
    */
   @Test
   public void testGetListeners() {
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("org.apache.pluto.container.om.portlet.impl.fixtures.TestListener", list.get(0).getListenerClass());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void testAddListener() {
      String clsName = "org.apache.pluto.container.om.portlet.impl.fixtures.DifferentListener";
      Listener newitem = new ListenerImpl(clsName);
      cut.addListener(newitem);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(clsName, list.get(1).getListenerClass());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getSecurityConstraints()}.
    */
   @Test
   public void testGetSecurityConstraints() {
      List<SecurityConstraint> list = cut.getSecurityConstraints();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("NONE", list.get(0).getUserDataConstraint().getTransportGuarantee());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addSecurityConstraint(org.apache.pluto.container.om.portlet.SecurityConstraint)}.
    */
   @Test
   public void testAddSecurityConstraint() {
      SecurityConstraint seco = new SecurityConstraintImpl(new UserDataConstraintImpl("CONFIDENTIAL"));
      cut.addSecurityConstraint(seco);
      
      List<SecurityConstraint> list = cut.getSecurityConstraints();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals("CONFIDENTIAL", list.get(1).getUserDataConstraint().getTransportGuarantee());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getLocaleEncodingMappings()}.
    * @throws Exception 
    */
   @Test
   public void testGetLocaleEncodingMappings() throws Exception {
      String file = WEBDDPKG + WEBDD31;
      InputStream in = this.getClass().getClassLoader().getResourceAsStream(file);
      
      try {
         cfp.processWebDD(in);
         pad = cfp.getPad();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }

      Map<Locale, String> localemap = pad.getLocaleEncodingMappings();
      assertEquals(2, localemap.size());
      ArrayList<Locale> testlocs = new ArrayList<Locale>(Arrays.asList(new Locale[]{
            Locale.forLanguageTag("de"), Locale.forLanguageTag("ja") }));
      String[] testencs = {"UTF-8", "Shift_JIS"};
      for (Locale loc : localemap.keySet()) {
         assertTrue(testlocs.contains(loc));
         int ind = testlocs.indexOf(loc);
         assertEquals(testencs[ind], localemap.get(loc));
      }
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
