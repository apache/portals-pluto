/*
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
package org.apache.pluto.spi.optional;

import java.util.Iterator;

import org.apache.pluto.PortletContainerException;
import org.apache.pluto.internal.InternalPortletConfig;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

/**
 * Interface defining the services used by the container
 * to access portlet applications.  The registry
 * acts as both registry and publically
 * as a mechanism for notifying the container of new applications.
 *
 * @since 1.1.0
 *
 */
public interface PortletRegistryService {

    /**
     * Retrieve all registered applications.  This list
     * will only contain those applications which have
     * been registered with the container.  Others may
     * or may not be available within the servers.
     *
     * @return iterator of all application descriptors.
     */
    Iterator<InternalPortletContext> getPortletContexts();

    /**
     * Retrieve the ids of all registered applications.
     * This list will only contain those applications
     * which have been registered with the container.
     * Others may or may not be available within
     * the servers.
     *
     * @return iterator of all PortletApp ids (strings).
     */
    Iterator<String> getRegisteredPortletApplicationIds();

    /**
     * Retrieve the PortletApp for the specified
     * portlet application id.
     *
     * @param applicationId the id of the portlet application.
     * @return the named PortletApp.
     * @throws PortletContainerException if the portlet application 
     *         isn't registered.
     */
    PortletApplicationDefinition getPortletApplication(String applicationId)
        throws PortletContainerException;

    /**
     * Retrieve the InternalPortletContext for the specified portlet application id
     *
     * @param applicationId portlet application id
     * @return portlet context or null if not registered
     */
    InternalPortletContext getPortletContext(String applicationId)
        throws PortletContainerException;

    /**
     * Retreive the Portlet for the specified portlet.
     *
     * @param applicationId portlet application id
     * @param portletName portlet name
     * @return portlet
     * @throws PortletContainerException if portlet or application unknown
     */
    PortletDefinition getPortlet(String applicationId, String portletName)
        throws PortletContainerException;

    /**
     * Retrieve the portlet configuration for the specified portlet
     * @param applicationIid portlet application id
     * @param portletName portlet name
     * @return portletconfig
     * @throws PortletContainerException if portlet or application unknown
     */
    InternalPortletConfig getPortletConfig(String applicationId, String portletName)
        throws PortletContainerException;

    /**
     * Retrieve the ClassLoader of the specified portlet application
     * @param applicationId portlet application id
     * @return classLoader
     */
    ClassLoader getClassLoader(String applicationId)
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