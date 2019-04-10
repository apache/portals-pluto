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


package org.apache.pluto.container.om.portlet.impl.jsr168;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Junit test cases for JSR 168 portlet application definition.
 * @author Scott Nicklous
 *
 */
public class PortletApplicationDefinition168ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet168Generated.xml";
   
   private static PortletApplicationDefinition pad;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = PortletApplicationDefinition168ImplTest.class
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

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getId()}.
    */
   @Test
   public void testGetSetId() {
      String val = pad.getId();
      assertNotNull(val);
      assertEquals("id1", val);
      pad.setId("42");
      val = pad.getId();
      assertNotNull(val);
      assertEquals("42", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getName()}.
    */
   @Test
   public void testGetSetName() {
      pad.setName("Bob");
      String val = pad.getName();
      assertNotNull(val);
      assertEquals("Bob", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getContextPath()}.
    */
   @Test
   public void testSetGetContextPath() {
      pad.setContextPath("Bob");
      String val = pad.getContextPath();
      assertNotNull(val);
      assertEquals("Bob", val);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.PortletApplicationDefinitionImpl#getVersion()}.
    */
   @Test
   public void testGetSetVersion() {
      String val = pad.getVersion();
      assertNotNull(val);
      assertEquals("1.0", val);
      pad.setVersion("42");
      val = pad.getVersion();
      assertNotNull(val);
      assertEquals("42", val);
   }

}
