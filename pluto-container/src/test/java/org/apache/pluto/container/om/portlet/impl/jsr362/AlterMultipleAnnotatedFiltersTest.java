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
import static org.junit.Assert.assertNull;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.FilterImpl;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.MultipleAnnotatedFilters1;
import org.apache.pluto.container.om.portlet.impl.fixtures.MultipleAnnotatedFilters2;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestFilter;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class AlterMultipleAnnotatedFiltersTest {
   
   // defines both some portlets and a filter
   private static final Class<?> TEST_ANNOTATED_CLASS1 = MultipleAnnotatedFilters1.class;
   private static final Class<?> TEST_ANNOTATED_CLASS2 = MultipleAnnotatedFilters2.class;
   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet362AlterFilter.xml";
   
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
      classes.add(TEST_ANNOTATED_CLASS1);
      classes.add(TEST_ANNOTATED_CLASS2);
      cfp = new ConfigurationHolder();
      try {
         cfp.processConfigAnnotations(classes);
         cfp.processPortletDD(in);
         try {
            cfp.validate();         // validate to expand the filter mapping portlet names
         } catch (Exception e) {}   // ignore any validation problems.
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
      String fn1 = "aFilter";
      String fn2 = "bFilter";
      Filter fil1 = cut.getFilter(fn1);
      assertNotNull(fil1);
      assertEquals(-40, fil1.getOrdinal());
      Filter fil2 = cut.getFilter(fn2);
      assertNull(fil2);
      assertEquals(TestFilter.class.getCanonicalName(), fil1.getFilterClass());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void testAddFilter() {
      String newItem = "newFilter";
      String oldItem1 = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(-101);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(0).getFilterName());
      assertEquals(oldItem1, list.get(1).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void checkFilterOrder1() {
      String newItem = "newFilter";
      String oldItem1 = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(1000);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
      assertEquals(oldItem1, list.get(0).getFilterName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#addFilter(org.apache.pluto.container.om.portlet.Filter)}.
    */
   @Test
   public void checkFilterOrder2() {
      String newItem = "newFilter";
      String oldItem1 = "aFilter";
      Filter fil = new FilterImpl(newItem);
      fil.setFilterClass("SomeClass");
      fil.setOrdinal(0);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(2, list.size());
      assertEquals(newItem, list.get(1).getFilterName());
      assertEquals(oldItem1, list.get(0).getFilterName());
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

   @Test
   public void testAddDupFilter() {
      String fn = "aFilter";
      String fc = "SomeClass";
      Filter fil = new FilterImpl(fn);
      fil.setFilterClass(fc);
      fil.setOrdinal(200);
      cut.addFilter(fil);
      
      List<Filter> list = cut.getFilters();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals(fn, list.get(0).getFilterName());
      assertEquals(fc, list.get(0).getFilterClass());
   }

}
