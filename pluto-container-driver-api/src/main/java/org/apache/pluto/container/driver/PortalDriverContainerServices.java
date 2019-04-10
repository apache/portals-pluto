/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.pluto.container.driver;

/**
 * Defines the additional services needed for the Pluto Portal Driver to integrate with the Pluto Container
 * and accessed from the <code>org.apache.pluto.container.driver.PortletServlet3</code>
 * and the <code>org.apache.pluto.container.driver.impl.DefaultPortletInvokerService</code>.
 * These extra services are not required nor used by the container itself directly.
 *
 * @since 2.0
 * @version $Id$
 */
public interface PortalDriverContainerServices
{
    /**
     * Returns the portlet context services implementation
     * used by the container.
     *
     * @return registry service implementation
     */
    PortletContextService getPortletContextService();

    /**
     * Returns the portlet registry services implementation
     * used by the container.
     *
     * @return registry service implementation
     */
    PortletRegistryService getPortletRegistryService();

    /**
     * Returns the admin service implementation used by
     * the container.
     *
     * @return portal admin service
     */
    PortalAdministrationService getPortalAdministrationService();
}
