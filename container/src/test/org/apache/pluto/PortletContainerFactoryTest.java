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
package org.apache.pluto;

import org.jmock.Mock;
import org.apache.pluto.services.PortletContainerServices;
import org.apache.pluto.util.PlutoTestCase;

/**
 * Test Class
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since June 1, 2005
 */
public class PortletContainerFactoryTest extends PlutoTestCase {

    public void getInstanceTest() {
        assertNotNull(PortletContainerFactory.getInstance());
    }

    /**
     * Test the creation of a Portlet Container instance through
     * the factory.  This test validates that an instance is returned
     * and that the container name is consistent with the one provided.
     * Because the container could potentially proxy the services, we
     * do not validate that the services are equal to the one provided.
     * @throws PortletContainerException
     */
    public void testCreateContainer() throws PortletContainerException {
        Mock mock = new Mock(PortletContainerServices.class);
        PortletContainerServices services = (PortletContainerServices)mock.proxy();
        String name = "TestContainerName";

        PortletContainer container =
            PortletContainerFactory.getInstance().createContainer(name, services);
        assertNotNull("Container is null.", container);
        assertEquals("Incorrect container name.", name, container.getName());
    }

    public void testCreateContainerWithNullServices() {
        PortletContainerFactory factory = PortletContainerFactory.getInstance();
        assertException(factory, "createContainer",
                        new Class[] { String.class,  PortletContainerServices.class,  },
                        new Object[] { "test", null}, IllegalArgumentException.class);
    }

    public void testCreateContainerWithNullName() {
        Mock mock = new Mock(PortletContainerServices.class);
        PortletContainerServices services = (PortletContainerServices)mock.proxy();

        PortletContainerFactory factory = PortletContainerFactory.getInstance();
        assertException(factory, "createContainer",
                        new Class[] { String.class,  PortletContainerServices.class,  },
                        new Object[] { null, services}, IllegalArgumentException.class);
    }

    public void testCreateContainerWithEmptyName() {
        Mock mock = new Mock(PortletContainerServices.class);
        PortletContainerServices services = (PortletContainerServices)mock.proxy();

        PortletContainerFactory factory = PortletContainerFactory.getInstance();
        assertException(factory, "createContainer",
                        new Class[] { String.class,  PortletContainerServices.class,  },
                        new Object[] { "", services}, IllegalArgumentException.class);
    }
}
