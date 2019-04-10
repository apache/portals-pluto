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

import java.io.InputStream;
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
import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.Listener;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
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
import org.apache.pluto.container.om.portlet.impl.PublicRenderParameterImpl;
import org.apache.pluto.container.om.portlet.impl.SecurityConstraintImpl;
import org.apache.pluto.container.om.portlet.impl.UserAttributeImpl;
import org.apache.pluto.container.om.portlet.impl.UserDataConstraintImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestPortletAppAnnotatedClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for mer of portlet app definition from annotation
 * with that from the portlet.xml file.
 * 
 * @author Scott Nicklous
 *
 */
public class MergePortletAppTest {

   
   private static final Class<?> TEST_ANNOTATED_CLASS = TestPortletAppAnnotatedClass.class;
   private static final String  WEBDDPKG         = "org/apache/pluto/container/om/portlet/";
   private static final String  WEBDD31          = "webApp31simple.xml";

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362Merge.xml";
   
   private static PortletApplicationDefinition pad;
   private static ConfigurationHolder cfp;
   
   // class under test; cloned new for each test
   private  PortletApplicationDefinition cut;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = MergePortletAppTest.class
            .getClassLoader().getResourceAsStream(XML_FILE);

      Set<Class<?>> classes = new HashSet<Class<?>>();
      classes.add(TEST_ANNOTATED_CLASS);
      cfp = new ConfigurationHolder();
      try {
         // portlet XML must be processed after annotations
         cfp.processConfigAnnotations(classes);
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
    * Bundle from XML overrides bundle from annotation
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
    * Namespace from XML overrrides namespace from annotation
    */
   @Test
   public void testGetSetDefaultNamespace() {
      String val = cut.getDefaultNamespace();
      String txt = "https://www.ibm.com/";
      assertNotNull(val);
      assertEquals("https://www.some.org/", val);
      cut.setDefaultNamespace(txt);
      val = cut.getDefaultNamespace();
      assertNotNull(val);
      assertEquals(txt, val);
   }

   /**
    * Total event defs is uniion of annotation event defs & xml event defs
    */
   @Test
   public void testGetEventDefinitions() {
      List<EventDefinition> list = cut.getEventDefinitions();
      assertNotNull(list);
      assertEquals(3, list.size());
      QName qn = new QName("https://www.some.org/", "another-event");
      EventDefinition evt = new EventDefinitionImpl(qn);
      assertTrue(list.contains(evt));
   }

   /**
    * Total event defs is uniion of annotation event defs & xml event defs
    */
   @Test
   public void testGetEventDefinition() {
      QName qn = new QName("https://www.some.org/", "another-event");
      EventDefinition item = cut.getEventDefinition(qn);
      assertNotNull(item);
      qn = new QName("https://www.some.org/", "supported-event");
      item = cut.getEventDefinition(qn);
      assertNotNull(item);
      qn = new QName("http://test.com", "supported-event");
      item = cut.getEventDefinition(qn);
      assertNotNull(item);
   }

   /**
    * Total event defs is uniion of annotation event defs & xml event defs
    */
   @Test
   public void testAddEventDefinition() {
      QName qn = new QName("https://www.ibm.com/", "some-other-event");
      EventDefinition ed = new EventDefinitionImpl(qn);
      cut.addEventDefinition(ed);

      List<EventDefinition> list = cut.getEventDefinitions();
      assertNotNull(list);
      assertEquals(4, list.size());
      EventDefinition evt = new EventDefinitionImpl(qn);
      assertTrue(list.contains(evt));
   }

   /**
    * Total event defs is uniion of annotation event defs & xml event defs
    */
   @Test
   public void testAddDupEventDefinition() {
      QName qn = new QName("https://www.some.org/", "different-event");
      EventDefinition ed = new EventDefinitionImpl(qn);
      cut.addEventDefinition(ed);

      List<EventDefinition> list = cut.getEventDefinitions();
      assertNotNull(list);
      assertEquals(4, list.size());
      boolean ok = false;
      for (EventDefinition item : list) {
         if (item.getQName().equals(qn)) {
            ok = true;
         }
      }
      assertTrue(ok);
   }

   /**
    * Total prps are union of annotation prps & xml prps
    */
   @Test
   public void testGetPublicRenderParameter() {
      assertNotNull(cut.getPublicRenderParameter("color"));
      assertNotNull(cut.getPublicRenderParameter("imgName"));
      assertNotNull(cut.getPublicRenderParameter("link"));
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(3, prps.size());
   }
   
   private boolean isPrpPresent(String prpid, List<PublicRenderParameter> prps) {
      for (PublicRenderParameter prp : prps) {
         if (prp.getIdentifier().equals(prpid)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Total prps are union of annotation prps & xml prps
    */
   @Test
   public void testGetPublicRenderParameters() {
      String prpid = "imgName";
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(3, prps.size());
      assertTrue(isPrpPresent(prpid, prps));
   }

   /**
    * Total prps are union of annotation prps & xml prps
    */
   @Test
   public void testAddPublicRenderParameter() {
      String prpid = "newprp";
      QName qn = new QName("https://www.ibm.com/", "some-other-prp");
      PublicRenderParameter prp = new PublicRenderParameterImpl(qn, prpid);
      cut.addPublicRenderParameter(prp);
      
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(4, prps.size());
      assertTrue(isPrpPresent(prpid, prps));
   }

   /**
    * Total prps are union of annotation prps & xml prps
    */
   @Test
   public void testAddDupPublicRenderParameter() {
      String prpid = "color";
      QName qn = new QName("https://www.some.org/", "color");
      PublicRenderParameter prp = new PublicRenderParameterImpl(qn, prpid);
      cut.addPublicRenderParameter(prp);
      
      List<PublicRenderParameter> prps = cut.getPublicRenderParameters();
      assertNotNull(prps);
      assertEquals(3, prps.size());
      assertTrue(isPrpPresent(prpid, prps));
   }

   /**
    * Union of annotation modes & XML modes
    */
   @Test
   public void testGetCustomPortletMode() {
      assertNotNull(cut.getCustomPortletMode("portlet-mode"));
      assertNotNull(cut.getCustomPortletMode("admin"));
      assertNotNull(cut.getCustomPortletMode("aMode"));
   }
   
   private boolean isPMPresent(String pm, List<CustomPortletMode> list) {
      for (CustomPortletMode mode : list) {
         if (mode.getPortletMode().equals(pm)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Total portlet modes is union of annotation modes & XML modes
    */
   @Test
   public void testGetCustomPortletModes() {
      String newItem = "portlet-mode";
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isPMPresent(newItem, list));
   }

   /**
    * Total portlet modes is union of annotation modes & XML modes
    */
   @Test
   public void testAddCustomPortletMode() {
      String newItem = "newMode";
      CustomPortletMode prp = new CustomPortletModeImpl(newItem);
      cut.addCustomPortletMode(prp);
      
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(4, list.size());
      assertTrue(isPMPresent(newItem, list));
   }

   /**
    * Total portlet modes is union of annotation modes & XML modes
    */
   @Test
   public void testAddDuplicateCustomPortletMode() {
      String newItem = "portlet-mode";
      CustomPortletMode prp = new CustomPortletModeImpl(newItem);
      cut.addCustomPortletMode(prp);
      
      List<CustomPortletMode> list = cut.getCustomPortletModes();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isPMPresent(newItem, list));
   }
   
   private boolean isWSPresent(String ws, List<CustomWindowState> list) {
      for (CustomWindowState cws : list) {
         if (cws.getWindowState().equals(ws)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Total custom window states is union of annotation states & XML states
    */
   @Test
   public void testGetCustomWindowState() {
      assertNotNull(cut.getCustomWindowState("window-state"));
      assertNotNull(cut.getCustomWindowState("half_page"));
      assertNotNull(cut.getCustomWindowState("quarter_page"));
   }

   /**
    * Total custom window states is union of annotation states & XML states
    */
   @Test
   public void testGetCustomWindowStates() {
      String newItem = "window-state";
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isWSPresent(newItem, list));
   }

   /**
    * Total custom window states is union of annotation states & XML states
    */
   @Test
   public void testAddCustomWindowState() {
      String newItem = "newState";
      CustomWindowState prp = new CustomWindowStateImpl(newItem);
      cut.addCustomWindowState(prp);
      
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(4, list.size());
      assertTrue(isWSPresent(newItem, list));
   }

   /**
    * Total custom window states is union of annotation states & XML states
    */
   @Test
   public void testAddDupCustomWindowState() {
      String newItem = "window-state";
      CustomWindowState prp = new CustomWindowStateImpl(newItem);
      cut.addCustomWindowState(prp);
      
      List<CustomWindowState> list = cut.getCustomWindowStates();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isWSPresent(newItem, list));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttribute(java.lang.String)}.
    */
   @Test
   public void testGetUserAttribute() {
      assertNotNull(cut.getUserAttribute("user.name.given"));
      assertNotNull(cut.getUserAttribute("user.name.family"));
      assertNotNull(cut.getUserAttribute("dogs.name"));
      assertNotNull(cut.getUserAttribute("user.home-info.online.email"));
      assertNotNull(cut.getUserAttribute("user.business-info.postal.organization"));
   }
   
   private boolean isUAPresent(String ua, List<UserAttribute> list) {
      for (UserAttribute item : list) {
         if (item.getName().equals(ua)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getUserAttributes()}.
    */
   @Test
   public void testGetUserAttributes() {
      String newItem = "user.name.family";
      List<UserAttribute> list = cut.getUserAttributes();
      assertNotNull(list);
      assertEquals(5, list.size());
      assertTrue(isUAPresent(newItem, list));
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
      assertEquals(6, list.size());
      assertTrue(isUAPresent(newItem, list));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addUserAttribute(org.apache.pluto.container.om.portlet.UserAttribute)}.
    */
   @Test
   public void testAddDupUserAttribute() {
      String newItem = "user.name.family";
      UserAttribute prp = new UserAttributeImpl(newItem);
      cut.addUserAttribute(prp);
      
      List<UserAttribute> list = cut.getUserAttributes();
      assertNotNull(list);
      assertEquals(5, list.size());
      assertTrue(isUAPresent(newItem, list));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilter(java.lang.String)}.
    */
   @Test
   public void testGetFilter() {
      String newItem = "filter-name";
      String filterClass = "org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter";
      Filter item = cut.getFilter(newItem);
      assertNotNull(item);
      Filter filter = cut.getFilters().get(0);
      assertEquals(filterClass, 
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
      String filterClass = "org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass(filterClass);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void testRemoveFilter() {
      // existing filter def is removed if filter class is null (= not set)
      String newItem = "filter-name";
      Filter fil = new FilterImpl(newItem);
      assertNotNull(cut.getFilter(newItem));
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(0, list.size());
      assertEquals(null, cut.getFilter(newItem));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void testAddDupFilter() {
      String newItem = "filter-name";
      String filterClass = "org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass(filterClass);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
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
      assertEquals("AnnotatedPortlet", item.getPortletNames().get(0));
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
      String portletName = "portlet362";
      FilterMapping fm = new FilterMappingImpl(newItem);
      fm.addPortletName(portletName);
      cut.addFilterMapping(fm);
      
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilterMapping(org.apache.pluto.container.om.portlet.FilterMapping)}.
    */
   @Test
   public void testRemoveFilterMapping() {
      String newItem = "filter-name";
      FilterMapping fm = new FilterMappingImpl(newItem);
      assertNotNull(cut.getFilterMapping(newItem));
      cut.addFilterMapping(fm);
      
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(0, list.size());
      assertEquals(null, cut.getFilterMapping(newItem));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilterMapping(org.apache.pluto.container.om.portlet.FilterMapping)}.
    */
   @Test
   public void testAddDupFilterMapping() {
      String newItem = "filter-name";
      String portletName = "portlet362";
      FilterMapping fm = new FilterMappingImpl(newItem);
      fm.addPortletName(portletName);
      cut.addFilterMapping(fm);
      
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOption(java.lang.String)}.
    */
   @Test
   public void testGetContainerRuntimeOption() {
      assertNotNull(cut.getContainerRuntimeOption("javax.portlet.renderHeaders"));
      assertNotNull(cut.getContainerRuntimeOption("Runtime-Option-Portlet-App"));
      assertNotNull(cut.getContainerRuntimeOption("runtime.option"));
   }
   
   private boolean isRTOPresent(String rt, List<ContainerRuntimeOption> list) {
      for (ContainerRuntimeOption item : list) {
         if (item.getName().equals(rt)) {
            return true;
         }
      }
      return false;
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getContainerRuntimeOptions()}.
    */
   @Test
   public void testGetContainerRuntimeOptions() {
      String newItem = "Runtime-Option-Portlet-App";
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isRTOPresent(newItem, list));
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
      assertEquals(4, list.size());
      assertTrue(isRTOPresent(newItem, list));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addContainerRuntimeOption(org.apache.pluto.container.om.portlet.ContainerRuntimeOption)}.
    */
   @Test
   public void testAddDupContainerRuntimeOption() {
      String newItem = "Runtime-Option-Portlet-App";
      String[] newvals = {"v1", "v2"}; 
      ContainerRuntimeOption item = new ContainerRuntimeOptionImpl(newItem, Arrays.asList(newvals));
      cut.addContainerRuntimeOption(item);
      
      List<ContainerRuntimeOption> list = cut.getContainerRuntimeOptions();
      assertNotNull(list);
      assertEquals(3, list.size());
      assertTrue(isRTOPresent(newItem, list));
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
      assertEquals("test listener", list.get(0).getListenerName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void testAddListener() {
      String clsName = "org.apache.pluto.container.om.portlet.impl.fixtures.DifferentListener";
      String lisName = "Different Listener";
      Listener newitem = new ListenerImpl(clsName);
      newitem.setListenerName(lisName);
      
      cut.addListener(newitem);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(clsName, list.get(1).getListenerClass());
      assertEquals(lisName, list.get(1).getListenerName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addListener(org.apache.pluto.container.om.portlet.Listener)}.
    */
   @Test
   public void testAddDupListener() {
      String clsName = "org.apache.pluto.container.om.portlet.impl.fixtures.TestListener";
      String lisName = "test listener";
      Listener newitem = new ListenerImpl(clsName);
      newitem.setListenerName(lisName);
      
      cut.addListener(newitem);
      
      List<Listener> list = cut.getListeners();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(clsName, list.get(0).getListenerClass());
      assertEquals(lisName, list.get(0).getListenerName());
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
      assertEquals(1, list.size());
      assertEquals("CONFIDENTIAL", list.get(0).getUserDataConstraint().getTransportGuarantee());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addSecurityConstraint(org.apache.pluto.container.om.portlet.SecurityConstraint)}.
    */
   @Test
   public void testAddDupSecurityConstraint() {
      SecurityConstraint seco = new SecurityConstraintImpl(new UserDataConstraintImpl("NONE"));
      cut.addSecurityConstraint(seco);
      
      List<SecurityConstraint> list = cut.getSecurityConstraints();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("NONE", list.get(0).getUserDataConstraint().getTransportGuarantee());
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
