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

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.UserAttribute;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.DescriptionImpl;
import org.apache.pluto.container.om.portlet.impl.UserAttributeImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Scott Nicklous
 *
 */
public class UserAttribute168ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet168Generated.xml";
   
   private static PortletApplicationDefinition pad;
   private        List<UserAttribute> attrs;
   private        UserAttribute ua;

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
   
   @Before
   public void setUpBefore() throws Exception {
      attrs = new ArrayList<UserAttribute>();
      for (UserAttribute ua : pad.getUserAttributes()) {
         attrs.add(new UserAttributeImpl(ua));
      }
      assertEquals(1, attrs.size());
      ua = attrs.get(0);
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserAttributeImpl#getName()}.
    */
   @Test
   public void testGetName() {
      assertEquals("name", ua.getName());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserAttributeImpl#getDescription(java.util.Locale)}.
    */
   @Test
   public void testGetDescription() {
      Locale loc = new Locale("DE");
      Description desc = ua.getDescription(loc);
      assertNotNull(desc);
      assertEquals("description", desc.getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserAttributeImpl#getDescriptions()}.
    */
   @Test
   public void testGetDescriptions() {
      List<Description> list = ua.getDescriptions();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("description", list.get(0).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserAttributeImpl#addDescription(org.apache.pluto.container.om.portlet.Description)}.
    */
   @Test
   public void testAddDescription() {
      Locale loc = Locale.FRENCH;
      String text = "Some description";
      Description d = new DescriptionImpl(loc, text);
      ua.addDescription(d);

      List<Description> list = ua.getDescriptions();
      assertNotNull(list);
      assertEquals(2, list.size());
      for (Description desc : list) {
         if (desc.getLocale().equals(loc)) {
            assertEquals(text, desc.getText());
         } else {
            assertEquals("description", desc.getText());
         }
      }
   }

}
