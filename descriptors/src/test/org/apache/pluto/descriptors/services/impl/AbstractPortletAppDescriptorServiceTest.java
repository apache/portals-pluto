/*
 * Copyright 2004 The Apache Software Foundation
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
package org.apache.pluto.descriptors.services.impl;

import java.io.InputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import junit.framework.TestCase;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;

/**
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Mar 23, 2005
 */
public class AbstractPortletAppDescriptorServiceTest extends TestCase {

    private AbstractPortletAppDescriptorService service;

    public AbstractPortletAppDescriptorServiceTest() {

    }

    public void setUp() {
        service = new ServiceImpl();
    }

    public void tearDown() {
        service = null;
    }

    public void testPortletCount() throws IOException {
       PortletAppDD dd = service.read();
       assertEquals(dd.getPortlets().size(), 2);
    }

    public void testPortletNames() throws IOException {
        PortletAppDD dd = service.read();
        assertNotNull(dd.getPortlet("TestPortlet1"));
        assertNotNull(dd.getPortlet("TestPortlet2"));
    }

    public void testPortletClassNames() throws IOException {
        PortletAppDD app = service.read();
        PortletDD dd = app.getPortlet("TestPortlet1");
        assertEquals(dd.getPortletClass(),
                     "org.apache.pluto.portalImpl.portlet.TestPortlet");
    }

    public class ServiceImpl extends AbstractPortletAppDescriptorService {

        public ServiceImpl() {
            super("test-context");
        }

        protected InputStream getInputStream() throws IOException {
            return new  ByteArrayInputStream(XML.getBytes());
        }

        protected OutputStream getOutputStream() throws IOException {
            return new ByteArrayOutputStream();
        }
    }

    public static final String XML =
    "<portlet-app xmlns=\"http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd\" "+
    "version=\"1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "+
    "xsi:schemaLocation=\"http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd "+
                        "http://java.sun.com/xml/ns/portlet/portlet-app_1_0.xsd\">"+
	"<portlet>"+
        "<description>Test #1</description>"+
        "<portlet-name>TestPortlet1</portlet-name>"+
        "<display-name>Test Portlet #1</display-name>"+
        "<portlet-class>org.apache.pluto.portalImpl.portlet.TestPortlet</portlet-class>"+
        "<init-param>"+
        "    <name>config</name>"+
        "    <value>/WEB-INF/testsuite-config.xml</value>"+
        "</init-param>"+
    "</portlet>"+
    "<portlet>"+
        "<description>TestSuiteDescription</description>"+
        "<portlet-name>TestPortlet2</portlet-name>"+
        "<display-name>Test Portlet #1</display-name>"+
        "<portlet-class>org.apache.pluto.portalImpl.portlet.TestPortlet</portlet-class>"+
        "<init-param>"+
        "    <name>config</name>"+
        "    <value>/WEB-INF/testsuite-config.xml</value>"+
        "</init-param>"+
    "</portlet>"+
    "</portlet-app>";
}

