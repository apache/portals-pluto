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
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;

import org.apache.pluto.container.om.portlet.impl.fixtures.TestPortlet;
import org.apache.pluto.container.om.portlet20.impl.ContainerRuntimeOptionType;
import org.apache.pluto.container.om.portlet20.impl.InitParamType;
import org.apache.pluto.container.om.portlet20.impl.PortletAppType;
import org.apache.pluto.container.om.portlet20.impl.PortletType;
import org.junit.Before;
import org.junit.Test;

/**
 * Low-level test to read a deployment descriptor
 */
public class JaxbReadTest286Gen {

   private static final String XML_FILE     = "org/apache/pluto/container/om/portlet/portlet286Generated.xml";
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
   public void portlet286Generated() throws Exception {
      assertEquals(portletApp.getPortlet().size(), 1);
      PortletType portlet = portletApp.getPortlet().get(0);
      assertNotNull(portlet);
      
      assertEquals("portlet286", portlet.getPortletName().getValue());
      assertEquals(1, portlet.getDisplayName().size());
      assertEquals("display-name", portlet.getDisplayName().get(0).getValue());
      assertEquals(0, portlet.getDisplayName().get(0).getLang().compareTo("de"));
      
      // Check out the init parameter
      List<InitParamType> params = portlet.getInitParam();
      assertEquals(2, params.size());
      InitParamType param = null;
      for (InitParamType p : portlet.getInitParam()) {
         if (p.getName().getValue().equals("name")) {
            param = p;
            break;
         }
      }
      assertNotNull(param);
      assertEquals(1, param.getDescription().size());
      assertEquals(0, param.getDescription().get(0).getLang().compareTo("de"));
      assertEquals(0, param.getDescription().get(0).getValue().compareTo("description"));
      assertEquals("value", param.getValue().getValue());
      
      // test expiration cache value
      assertNotNull(portlet.getExpirationCache());
      assertTrue(portlet.getExpirationCache().getValue() == 50);

      // check for some stuff from the portlet application
      assertEquals("portlet-mode", portletApp.getCustomPortletMode().get(0).getPortletMode().getValue());
      assertEquals("window-state", portletApp.getCustomWindowState().get(0).getWindowState().getValue());
      assertEquals("name", portletApp.getUserAttribute().get(0).getName().getValue());
      assertEquals("portlet.name", portletApp.getSecurityConstraint().get(0)
            .getPortletCollection().getPortletName().get(0).getValue());
      
      // Some additional stuff from old test suite
      assertTrue(portlet.getPortletClass().equals(TestPortlet.class.getCanonicalName()));
      assertTrue(portlet.getPortletInfo().getTitle().getValue().equals("title"));
      assertEquals( "supports size should be 3", 3, portlet.getSupports().size());
      
      assertEquals("portlet.name", portletApp.getSecurityConstraint().get(0).getPortletCollection().getPortletName().get(0).getValue());
      assertEquals("org.apache.pluto.container.om.portlet.impl.fixtures.TestEventType", portletApp.getEventDefinition().get(0).getValueType());
      assertEquals("lifecycle", portletApp.getFilter().get(0).getLifecycle().get(0));
      assertEquals("portlet286", portletApp.getFilterMapping().get(0).getPortletName().get(0).getValue());
      assertEquals("org.apache.pluto.container.om.portlet.GoodBundle", portletApp.getResourceBundle().getValue());
      assertEquals("2.0", portletApp.getVersion());
      
      // test container runtime options
      assertEquals(1, portletApp.getContainerRuntimeOption().size());
      assertEquals("Runtime-Option-Portlet-App", portletApp.getContainerRuntimeOption().get(0).getName().getValue());
      assertEquals("false", portletApp.getContainerRuntimeOption().get(0).getValue().get(0).getValue());
      
      assertEquals(2, portlet.getContainerRuntimeOption().size());
      ContainerRuntimeOptionType opt = null;
      for (ContainerRuntimeOptionType c : portlet.getContainerRuntimeOption()) {
         if (c.getName().getValue().equalsIgnoreCase("Runtime-Option1")) {
            opt = c;
         }
      }
      assertNotNull(opt);
      assertEquals("true", opt.getValue().get(0).getValue());

   }
   
}
