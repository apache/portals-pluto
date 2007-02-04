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
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.DisplayNameDD;

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
        assertEquals("1.0", dd.getVersion());
        assertEquals(1, dd.getPortlets().size());

        PortletDD pd = (PortletDD)dd.getPortlets().get(0);
        assertEquals(2, pd.getDisplayNames().size());
        assertEquals("About Portlet", ((DisplayNameDD)pd.getDisplayNames().get(0)).getDisplayName());
        assertEquals("en", ((DisplayNameDD)pd.getDisplayNames().get(0)).getLang());
        assertEquals("fr", ((DisplayNameDD)pd.getDisplayNames().get(1)).getLang());
        assertEquals(30, pd.getExpirationCache());
        assertEquals(1, pd.getSupportedLocales().size());
        assertEquals("en", pd.getSupportedLocales().get(0));

        assertEquals(2, dd.getCustomPortletModes().size());
        assertEquals(2, dd.getCustomWindowStates().size());
        assertEquals(1, dd.getUserAttributes().size());
        assertEquals(1, dd.getSecurityConstraints().size());

        SecurityConstraintDD sc = (SecurityConstraintDD)dd.getSecurityConstraints().get(0);
        assertNotNull(sc.getPortletCollection());
        assertEquals(1, sc.getDisplayNames().size());
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
        "<portlet>"+
        "<description>AboutPortletDescription</description>"+
        "<portlet-name>AboutPortlet</portlet-name>"+
        "<display-name>About Portlet</display-name>"+
        "<display-name xml:lang=\"fr\">About Portlet</display-name>"+
        "<portlet-class>org.apache.pluto.driver.portlets.AboutPortlet</portlet-class>"+
        "<expiration-cache>30</expiration-cache>"+
        "<supports>"+
        "<mime-type>text/html</mime-type>"+
        "<portlet-mode>VIEW</portlet-mode>"+
        "<portlet-mode>EDIT</portlet-mode>"+
        "<portlet-mode>HELP</portlet-mode>"+
        "</supports>"+
        "<supported-locale>en</supported-locale>"+
        "<portlet-info>"+
        "<title>About Apache Pluto</title>"+
        "</portlet-info>"+
        "</portlet>"+
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
