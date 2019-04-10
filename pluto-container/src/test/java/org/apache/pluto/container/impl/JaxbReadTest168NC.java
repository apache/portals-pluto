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

package org.apache.pluto.container.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.container.om.portlet10.impl.PortletAppType;
import org.apache.pluto.container.om.portlet10.impl.PortletType;
import org.junit.Before;
import org.junit.Test;

/**
 * Low-level test to read a deployment descriptor
 */
public class JaxbReadTest168NC {

   private static final String XML_FILE     = "org/apache/pluto/container/om/portlet/portlet168NoCache.xml";
   private static final String JAXB_CONTEXT = "org.apache.pluto.container.om.portlet10.impl:"
                                                  + "org.apache.pluto.container.om.portlet20.impl:"
                                                  + "org.apache.pluto.container.om.portlet30.impl";

   PortletAppType    portletApp;

   @Before
   public void setUp() throws Exception {

      try {
         JAXBContext cntxt = JAXBContext.newInstance(JAXB_CONTEXT);
         InputStream in = this.getClass().getClassLoader().getResourceAsStream(XML_FILE);
         Unmarshaller um = cntxt.createUnmarshaller();
         JAXBElement<?> jel = (JAXBElement<?>) um.unmarshal(in);
         assertNotNull(jel.getValue());
         assertTrue(jel.getValue() instanceof PortletAppType);
         portletApp = (PortletAppType) jel.getValue();
      } catch (Exception e) {
         System.out.println("\nException during setup: " + e.getMessage()
               + "\n");
         throw e;
      }
   }

   @Test
   public void test1() throws Exception {
      assertEquals(portletApp.getPortlet().size(), 1);
      PortletType portlet = portletApp.getPortlet().get(0);
      assertNotNull(portlet);
      
      assertEquals("AboutPortlet", portlet.getPortletName().getValue());
      
      // Check out the init parameter
      assertEquals(1, portlet.getInitParam().size());
      assertEquals(1, portlet.getInitParam().get(0).getDescription().size());
      assertEquals(0, portlet.getInitParam().get(0).getDescription().get(0)
            .getLang().compareTo("de"));
      assertEquals(0, portlet.getInitParam().get(0).getDescription().get(0)
            .getValue().compareTo("a"));
      assertEquals("b", portlet.getInitParam().get(0).getName().getValue());
      assertEquals("v", portlet.getInitParam().get(0).getValue().getValue());
      
      // test (non-existent) expiration cache value
      assertNull(portlet.getExpirationCache());

      // check for some stuff from the portlet application
      assertEquals("portlet-mode", portletApp.getCustomPortletMode().get(0).getPortletMode().getValue());
      assertEquals("window-state", portletApp.getCustomWindowState().get(0).getWindowState().getValue());
      assertEquals("name", portletApp.getUserAttribute().get(0).getName().getValue());
      assertEquals("portlet-name", portletApp.getSecurityConstraint().get(0)
            .getPortletCollection().getPortletName().get(0).getValue());

      assertEquals(portletApp.getVersion() ,  "1.0");
  
   }
   
}
