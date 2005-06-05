/*
 * Copyright 2005 The Apache Software Foundation.
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
package org.apache.pluto.core;

import javax.servlet.ServletContext;

import org.apache.pluto.core.PortletContainerImpl;
import org.apache.pluto.util.PlutoTestCase;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.services.PortletContainerServices;
import org.jmock.Mock;
import junit.framework.TestSuite;
import junit.framework.AssertionFailedError;

/**
 * Test Class
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since June 1, 2005
 */
public class PortletContainerImplTest extends PlutoTestCase {

    private PortletContainerImpl container;
    private Mock servicesMock;
    private Mock servletContextMock;
    private String containerName;

    public void setUp() throws Exception {
        super.setUp();

        containerName = "TestContainer";

        servicesMock = new Mock(PortletContainerServices.class);
        PortletContainerServices services =
            (PortletContainerServices) servicesMock.proxy();

        container = new PortletContainerImpl(containerName, services);

        servletContextMock = new Mock(ServletContext.class);
        ServletContext context = (ServletContext)servletContextMock.proxy();
        container.init(context);
    }

    public void testInitialization() {
        assertTrue(container.isInitialized());
    }

    public void testDestroy() {
        container.destroy();
        assertFalse(container.isInitialized());
    }

    public void testGetName() {
        assertEquals(containerName, container.getName());
    }

    public void testGetContainerServices() {
        assertNotNull(container.getContainerServices());
    }

    /*
    public void testDoRender() {

    }

    public void testDoAction() {

    }

    public void testDoLoad() {

    }
    */
}
