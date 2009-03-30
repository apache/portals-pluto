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

import javax.servlet.ServletConfig;

import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletWindow;

/**
 * Interface defining the services used by both the Pluto Portal Driver
 * and the Pluto PortletServlet for registration and access to 
 * the PortletContexts and ClassLoader of registered Portlet Applications.
 *
 * @since 2.0
 * @version $Id$
 *
 */
public interface PortletContextService
{
    /**
     * Retrieve all registered applications.  This list
     * will only contain those applications which have
     * been registered with the container.  Others may
     * or may not be available within the servers.
     *
     * @return iterator of all application descriptors.
     */
    Iterator<DriverPortletContext> getPortletContexts();

    /**
     * Retrieve the InternalPortletContext for the specified portlet application name
     *
     * @param applicationName portlet application name
     * @return portlet context or null if not registered
     */
    DriverPortletContext getPortletContext(String applicationName)
        throws PortletContainerException;

    /**
     * Retrieve the InternalPortletContext for the specified portlet window
     *
     * @param portletWindow portlet window
     * @return portlet context or null if not registered
     */
    DriverPortletContext getPortletContext(PortletWindow portletWindow)
        throws PortletContainerException;

    /**
     * Retrieve the portlet configuration for the specified portlet
     * @param applicationName portlet application name
     * @param portletName portlet name
     * @return portletconfig
     * @throws PortletContainerException if portlet or application unknown
     */
    DriverPortletConfig getPortletConfig(String applicationName, String portletName)
        throws PortletContainerException;

    /**
     * Retrieve the ClassLoader of the specified portlet application
     * @param applicationName portlet application name
     * @return classLoader
     */
    ClassLoader getClassLoader(String applicationName)
        throws PortletContainerException;
    
    /**
     * Register a portlet application
     * 
     * @param config
     * @return
     * @throws PortletContainerException
     */
    String register(ServletConfig config) throws PortletContainerException;
    
    /**
     * Unregister a portlet application
     * 
     * @param context
     */
    void unregister(DriverPortletContext context);
}
