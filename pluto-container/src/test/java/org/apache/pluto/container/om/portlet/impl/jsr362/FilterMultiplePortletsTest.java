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
import java.util.Set;

import javax.portlet.PortletRequest;

import org.apache.pluto.container.om.portlet.Filter;
import org.apache.pluto.container.om.portlet.FilterMapping;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedFilterMultiple;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class FilterMultiplePortletsTest {
   
   // defines both some portlets and a filter
   private static final Class<?> TEST_ANNOTATED_CLASS = TestAnnotatedFilterMultiple.class;
   
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
      String newItem = "aFilter";
      Filter item = cut.getFilter(newItem);
      assertNotNull(item);
      Filter filter = cut.getFilters().get(0);
      assertEquals(TEST_ANNOTATED_CLASS.getCanonicalName(), 
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

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl#getFilterMapping(java.lang.String)}.
    */
   @Test
   public void testGetFilterMapping() {
      String newItem = "aFilter";
      FilterMapping item = cut.getFilterMapping(newItem);
      assertNotNull(item);
      List<String> names = item.getPortletNames();
      assertEquals(3, names.size());
      assertTrue(names.contains("portlet1"));
      assertTrue(names.contains("portlet2"));
      assertTrue(names.contains("portlet3"));
   }

}
