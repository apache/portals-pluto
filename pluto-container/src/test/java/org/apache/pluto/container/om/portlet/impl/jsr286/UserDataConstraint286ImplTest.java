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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import org.apache.pluto.container.om.portlet.Description;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.SecurityConstraint;
import org.apache.pluto.container.om.portlet.UserDataConstraint;
import org.apache.pluto.container.om.portlet.impl.ConfigurationHolder;
import org.apache.pluto.container.om.portlet.impl.DescriptionImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserDataConstraint286ImplTest {

   private static final String XML_FILE = 
         "org/apache/pluto/container/om/portlet/portlet286Generated.xml";
   
   private static PortletApplicationDefinition pad;
   private        UserDataConstraint udc;

   /**
    * @throws java.lang.Exception
    */
   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
      
      InputStream in = UserDataConstraint286ImplTest.class
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
      assertEquals(1, pad.getSecurityConstraints().size());
      SecurityConstraint sc = pad.getSecurityConstraints().get(0);
      assertNotNull(sc);
      assertNotNull(sc.getUserDataConstraint());
      udc = sc.getUserDataConstraint();
   }

   @Test
   public void testGetTransportGuarantee() {
      assertEquals("NONE", udc.getTransportGuarantee());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserDataConstraintImpl#getDescription(java.util.Locale)}.
    */
   @Test
   public void testGetDescription() {
      Locale loc = new Locale("DE");
      Description desc = udc.getDescription(loc);
      assertNotNull(desc);
      assertEquals("description", desc.getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserDataConstraintImpl#getDescriptions()}.
    */
   @Test
   public void testGetDescriptions() {
      List<Description> list = udc.getDescriptions();
      assertNotNull(list);
      assertEquals(1, list.size());
      assertEquals("description", list.get(0).getText());
   }

   /**
    * Test method for {@link org.apache.pluto.container.om.portlet.impl.jsr168.UserDataConstraintImpl#addDescription(org.apache.pluto.container.om.portlet.Description)}.
    */
   @Test
   public void testAddDescription() {
      Locale loc = Locale.FRENCH;
      String text = "Some description";
      Description d = new DescriptionImpl(loc, text);
      udc.addDescription(d);

      List<Description> list = udc.getDescriptions();
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
