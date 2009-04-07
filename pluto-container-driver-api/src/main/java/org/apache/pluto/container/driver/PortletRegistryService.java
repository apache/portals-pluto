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

import java.util.Iterator;

import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;

/**
 * Interface defining the services used by the container
 * to access portlet applications.  The registry
 * acts as both registry and publically
 * as a mechanism for notifying the container of new applications.
 *
 * @since 1.1.0
 *
 */
public interface PortletRegistryService 
{
    /**
     * Retrieve the names of all registered applications.
     * This list will only contain those applications
     * which have been registered with the container.
     * Others may or may not be available within
     * the servers.
     *
     * @return iterator of all PortletApp names (strings).
     */
    Iterator<String> getRegisteredPortletApplicationNames();

    /**
     * Retrieve the PortletApp for the specified
     * portlet application Name.
     *
     * @param applicationName the name of the portlet application.
     * @return the named PortletApp.
     * @throws PortletContainerException if the portlet application 
     *         isn't registered.
     */
    PortletApplicationDefinition getPortletApplication(String applicationName)
        throws PortletContainerException;

    /**
     * Retreive the Portlet for the specified portlet.
     *
     * @param applicationName portlet application name
     * @param portletName portlet name
     * @return portlet
     * @throws PortletContainerException if portlet or application unknown
     */
    PortletDefinition getPortlet(String applicationName, String portletName)
        throws PortletContainerException;

    /**
     * Add a listener which will recieve notifications of newly
     * registered applications.
     *
     * @param listener the listener to add
     */
    void addPortletRegistryListener(PortletRegistryListener listener);

    /**
     * Remove a previously registered listener.
     *
     * @param listener the listener to remove
     */
    void removePortletRegistryListener(PortletRegistryListener listener);
    
}