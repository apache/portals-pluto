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

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import org.apache.pluto.container.om.portlet.CustomPortletMode;
import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.CustomPortletModeImpl;
import org.apache.pluto.container.om.portlet.impl.DescriptionImpl;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Scott Nicklous
 *
 */
public class CustomPortletMode286ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet286Generated.xml";
   
   private static PortletApplicationDefinition pad;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      InputStream in = CustomPortletMode286ImplTest.class
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
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.CustomPortletModeImpl#getPortletMode()}.
    */
   @Test
   public void testGetPortletMode() {
      CustomPortletMode cpm = pad.getCustomPortletMode("portlet-mode");
      assertNotNull(cpm);
      assertEquals(1, pad.getCustomPortletModes().size());
      cpm = pad.getCustomPortletModes().get(0);
      assertEquals("portlet-mode", cpm.getPortletMode());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.CustomPortletModeImpl#isPortalManaged()}.
    */
   @Test
   public void testGetIsPortalManaged() {
      CustomPortletMode cpm = pad.getCustomPortletMode("portlet-mode");
      assertNotNull(cpm);
      assertEquals(1, pad.getCustomPortletModes().size());
      cpm = pad.getCustomPortletModes().get(0);
      assertFalse(cpm.isPortalManaged());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.CustomPortletModeImpl#getDescription(java.util.Locale)}.
    */
   @Test
   public void testGetDescription() {
      assertEquals(1, pad.getCustomPortletModes().size());
      CustomPortletMode cpm = pad.getCustomPortletModes().get(0);
      Locale loc = new Locale("de");
      Description d = cpm.getDescription(loc);
      assertNotNull(d);
      assertEquals("description", d.getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.CustomPortletModeImpl#getDescriptions()}.
    */
   @Test
   public void testGetDescriptions() {
      assertEquals(1, pad.getCustomPortletModes().size());
      CustomPortletMode cpm = pad.getCustomPortletModes().get(0);
      assertEquals("portlet-mode", cpm.getPortletMode());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.CustomPortletModeImpl#addDescription(org.apache.pluto.container.om.portlet.Description)}.
    */
   @Test
   public void testAddDescription() {
      assertEquals(1, pad.getCustomPortletModes().size());
      CustomPortletMode cpm = 
            new CustomPortletModeImpl(pad.getCustomPortletModes().get(0));
      assertEquals(1, cpm.getDescriptions().size());
      Locale loc = Locale.FRENCH;
      String text = "Some description";
      Description d = new DescriptionImpl(loc, text);
      cpm.addDescription(d);
      
      List<Description> list = cpm.getDescriptions();
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
