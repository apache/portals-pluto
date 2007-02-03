/*
 * Copyright 2005-2007 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.descriptors.services.castor;

import junit.framework.TestCase;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.SecurityConstraintDD;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version $Id$
 * @since 1.1.0
 */
public class PortletAppDescriptorServiceImplTest extends TestCase {

    private PortletAppDescriptorServiceImpl service;

    public void setUp() {
        service = new PortletAppDescriptorServiceImpl();
    }

    public void testParse() throws IOException {
        InputStream in = new ByteArrayInputStream(xml.toString().getBytes());

        PortletAppDD dd = service.read(in);
        assertEquals(0, dd.getPortlets().size());
        assertEquals(2, dd.getCustomPortletModes().size());
        assertEquals(2, dd.getCustomWindowStates().size());
        assertEquals(1, dd.getUserAttributes().size());
        assertEquals(1, dd.getSecurityConstraints().size());

        SecurityConstraintDD sc = (SecurityConstraintDD)dd.getSecurityConstraints().get(0);
        assertNotNull(sc.getPortletCollection());
        assertEquals("description", sc.getDisplayName());
        assertEquals(3, sc.getPortletCollection().getPortletNames().size());
        assertEquals("a", sc.getPortletCollection().getPortletNames().get(0));
        assertEquals("b", sc.getPortletCollection().getPortletNames().get(1));
        assertEquals("c", sc.getPortletCollection().getPortletNames().get(2));

        assertNotNull(sc.getUserDataConstraint());
        assertEquals("scdescription", sc.getUserDataConstraint().getDescription());
        assertEquals("NONE", sc.getUserDataConstraint().getTransportGuarantee());
        
    }



    private String xml = "<portlet-app\n" +
        "    xmlns=\"http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd\"\n" +
        "    version=\"1.0\"\n" +
        "    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
        "    xsi:schemaLocation=\"http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd\n" +
        "                        http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd\">" +
        " <custom-portlet-mode><description>Test</description><portlet-mode>customMode</portlet-mode></custom-portlet-mode>" +
        " <custom-portlet-mode><description>Test2</description><portlet-mode>customMode2</portlet-mode></custom-portlet-mode>" +
        " <custom-window-state><description>Test</description><window-state>customWindow</window-state></custom-window-state>" +
        " <custom-window-state><description>Test2</description><window-state>customWindow2</window-state></custom-window-state>" +
        " <user-attribute><description>Test2</description><name>user</name></user-attribute>" +
        "    <security-constraint>\n" +
        "        <display-name>description</display-name>\n" +
        "        <portlet-collection>\n" +
        "            <portlet-name>a</portlet-name>\n" +
        "            <portlet-name>b</portlet-name>\n" +
        "            <portlet-name>c</portlet-name>\n" +
        "        </portlet-collection>\n" +
        "        <user-data-constraint>\n" +
        "            <description>scdescription</description>\n" +
        "            <transport-guarantee>NONE</transport-guarantee>\n" +
        "        </user-data-constraint>\n" +
        "    </security-constraint>" +
        "</portlet-app>";
}
