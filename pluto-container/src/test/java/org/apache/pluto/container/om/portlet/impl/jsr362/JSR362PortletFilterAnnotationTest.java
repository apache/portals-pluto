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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.FilterImpl;
import org.apache.pluto.container.om.portlet.impl.FilterMappingImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedFilter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class JSR362PortletFilterAnnotationTest {
   
   private static final Class<?> TEST_ANNOTATED_CLASS = TestAnnotatedFilter.class;
   
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
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilter(java.lang.String)}.
    */
   @Test
   public void testGetFilter() {
      String newItem = "aFilter";
      Filter item = cut.getFilter(newItem);
      assertNotNull(item);
      Filter filter = cut.getFilters().get(0);
      assertEquals("org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedFilter", 
            filter.getFilterClass());
      assertEquals("true", filter.getInitParam("execute").getParamValue());
   }
   
   @Test
   public void testFilterLifecycle() {
      String newItem = "aFilter";
      Filter filter = cut.getFilter(newItem);
      assertNotNull(filter);
      List<String> lifecycles =  Arrays.asList(new String[] {PortletRequest.RENDER_PHASE, PortletRequest.RESOURCE_PHASE, PortletRequest.HEADER_PHASE});
      for (String lc : filter.getLifecycles()) {
         assertTrue(lifecycles.contains(lc));
      }
   }
   
   @Test
   public void testFilterDescription() {
      String newItem = "aFilter";
      Filter filter = cut.getFilter(newItem);
      assertNotNull(filter);
      assertEquals(2, filter.getDescriptions().size());
      assertEquals("Ein ordentlicher Filter", filter.getDescription(new Locale("de")).getText());
      assertEquals("Quite the filter", filter.getDescription(Locale.ENGLISH).getText());
   }

   @Test
   public void testFilterDisplayName() {
      String newItem = "aFilter";
      Filter filter = cut.getFilter(newItem);
      assertNotNull(filter);
      assertEquals(2, filter.getDisplayNames().size());
      assertEquals("Ein Filter", filter.getDisplayName(Locale.GERMAN).getText());
      assertEquals("A Filter", filter.getDisplayName(new Locale("en")).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilters()}.
    */
   @Test
   public void testGetFilters() {
      String newItem = "aFilter";
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
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(100);
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
   public void checkFilterOrder1() {
      String newItem = "newFilter";
      String oldItem = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(10);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
      assertEquals(oldItem, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void checkFilterOrder2() {
      String newItem = "newFilter";
      String oldItem = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(1000);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
      assertEquals(oldItem, list.get(0).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void deleteFilter1() {
      String oldItem = "aFilter";
      Filter fil = new FilterImpl(oldItem);
      fil.setFilterClass(null);
      fil.setOrdinal(1000);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(0, list.size());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void deleteFilter2() {
      String oldItem = "aFilter";
      Filter fil = new FilterImpl(oldItem);
      fil.setFilterClass("");
      fil.setOrdinal(1000);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(0, list.size());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void testAddDupFilter() {
      String newItem = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
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
      String newItem = "aFilter";
      FilterMapping item = cut.getFilterMapping(newItem);
      assertNotNull(item);
      assertEquals(1, item.getPortletNames().size());
      assertEquals("portlet362", item.getPortletNames().get(0));
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilterMappings()}.
    */
   @Test
   public void testGetFilterMappings() {
      String newItem = "aFilter";
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
      fm.addPortletName("portlet 1");
      fm.addPortletName("portlet 2");
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
   public void testAddDupFilterMapping() {
      String newItem = "aFilter";
      FilterMapping fm = new FilterMappingImpl(newItem);
      fm.addPortletName("portlet 1");
      cut.addFilterMapping(fm);
      
      List<FilterMapping> list = cut.getFilterMappings();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
   }

}
