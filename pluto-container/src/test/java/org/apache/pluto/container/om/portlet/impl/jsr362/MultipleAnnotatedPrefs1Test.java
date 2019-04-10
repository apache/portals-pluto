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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.PortletApplicationDefinitionImpl;
import org.apache.pluto.container.om.portlet.impl.fixtures.TestAnnotatedPrefs1;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 362 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class MultipleAnnotatedPrefs1Test {
   
   // defines both some portlets and a Listener
   private static final Class<?> TEST_ANNOTATED_CLASS1 = TestAnnotatedPrefs1.class;
   
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
      classes.add(TEST_ANNOTATED_CLASS1);
      cfp = new ConfigurationHolder();
      try {
         cfp.processConfigAnnotations(classes);
         try {
            cfp.validate();         // validate and ignore any validation problems.
         } catch (Exception e) {}   
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
    * Tests that the default portletNames='*' value in the portlet
    * preferences validator annotation applies the validator to all
    * portlets in the portlet app.  
    */
   @Test
   public void testPrefs() {
      List<PortletDefinition> list = cut.getPortlets();
      assertNotNull(list);
      assertEquals(3, list.size());
      
      for (PortletDefinition item : list) {
         assertNotNull(item.getPortletPreferences());
         assertNotNull(item.getPortletPreferences().getPreferencesValidator());
         assertEquals(TEST_ANNOTATED_CLASS1.getCanonicalName(), 
               item.getPortletPreferences().getPreferencesValidator());
      }
   }

}
