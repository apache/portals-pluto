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

import static org.junit.Assert.*;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.container.om.portlet30.impl.PortletAppType;
import org.apache.pluto.container.om.portlet30.impl.PortletType;
import org.junit.Before;
import org.junit.Test;

/**
 * Low-level test to read a deployment descriptor
 */
public class JaxbReadTest362Gen {

   private static final String XML_FILE     = "org/apache/pluto/container/om/portlet/portlet362Generated.xml";
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
   public void portlet362Generated() throws Exception {
      assertEquals(portletApp.getPortlet().size(), 1);
      PortletType portlet = portletApp.getPortlet().get(0);
      assertNotNull(portlet);
      
      assertEquals("portlet362", portlet.getPortletName().getValue());
      assertEquals(1, portlet.getDisplayName().size());
      assertEquals("display-name", portlet.getDisplayName().get(0).getValue());
      assertEquals(0, portlet.getDisplayName().get(0).getLang().compareTo("de"));
      
      // Check out the init parameter
      assertEquals(2, portlet.getInitParam().size());
      assertEquals(1, portlet.getInitParam().get(0).getDescription().size());
      assertEquals(0, portlet.getInitParam().get(0).getDescription().get(0)
            .getLang().compareTo("de"));
      assertEquals(0, portlet.getInitParam().get(0).getDescription().get(0)
            .getValue().compareTo("description"));
      assertEquals("name", portlet.getInitParam().get(0).getName().getValue());
      assertEquals("value", portlet.getInitParam().get(0).getValue().getValue());
      
      // test expiration cache value
      assertNotNull(portlet.getExpirationCache());
      assertTrue(portlet.getExpirationCache().getValue() == 50);

      // check for some stuff from the portlet application
      assertEquals("portlet-mode", portletApp.getCustomPortletMode().get(0).getPortletMode().getValue());
      assertEquals("window-state", portletApp.getCustomWindowState().get(0).getWindowState().getValue());
      assertEquals("name", portletApp.getUserAttribute().get(0).getName().getValue());
      
      // Some additional stuff from old test suite
      assertTrue(portlet.getPortletClass().equals("org.apache.pluto.container.om.portlet.impl.fixtures.TestPortlet"));
      assertTrue(portlet.getPortletInfo().getTitle().get(0).getValue().equals("title"));
      assertEquals( "supports size should be 3", 3, portlet.getSupports().size());
      
      assertEquals("org.apache.pluto.container.om.portlet.impl.fixtures.TestEventType", portletApp.getEventDefinition().get(0).getValueType());
      assertEquals("lifecycle", portletApp.getFilter().get(0).getLifecycle().get(0));
      assertEquals("portlet362", portletApp.getFilterMapping().get(0).getPortletName().get(0).getValue());
      assertEquals("org.apache.pluto.container.om.portlet.GoodBundle", portletApp.getResourceBundle().getValue());
      assertEquals("3.0", portletApp.getVersion());
      
      // test container runtime options
      assertEquals(1, portletApp.getContainerRuntimeOption().size());
      assertEquals("Runtime-Option-Portlet-App", portletApp.getContainerRuntimeOption().get(0).getName().getValue());
      assertEquals("false", portletApp.getContainerRuntimeOption().get(0).getValue().get(0).getValue());
      
      assertEquals(2, portlet.getContainerRuntimeOption().size());
      assertEquals("Runtime-Option1", portlet.getContainerRuntimeOption().get(0).getName().getValue());
      assertEquals("true", portlet.getContainerRuntimeOption().get(0).getValue().get(0).getValue());

   }
   
}
