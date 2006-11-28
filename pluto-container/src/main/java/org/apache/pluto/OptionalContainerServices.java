/*
 * Copyright 2004 The Apache Software Foundation.
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

import org.apache.pluto.spi.optional.PortletPreferencesService;
import org.apache.pluto.spi.optional.PortletEnvironmentService;
import org.apache.pluto.spi.optional.PortletInvokerService;
import org.apache.pluto.spi.optional.PortletRegistryService;
import org.apache.pluto.internal.InternalPortletWindow;

/**
 * Defines the services necessary for integration between the Pluto Container
 * and a Portal.
 *
 * @since 1.1.0
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public interface OptionalContainerServices {

    /**
     * Returns the portlet preferences service implementation
     * used by the container.
     *
     * @return portlet preferences service implementation.
     */
    PortletPreferencesService getPortletPreferencesService();

    /**
     * Returns the environment services implementation
     * used by the container.
     *
     * @return portlet environment services implementation.
     */
    PortletEnvironmentService getPortletEnvironmentService();

    /**
     * Returns the portlet registry services implementation
     * used by the container.
     *
     * @return registry service implementation
     */
    PortletRegistryService getPortletRegistryService();

    
    /**
     * Returns an invoker for the specified PortletWindow.
     *
     * @param portletWindow  the InternalPortletWindow used for invocation.
     * @return an invoker which can be used to service the indicated portlet.
     */
    PortletInvokerService getPortletInvokerService(InternalPortletWindow portletWindow);

}
