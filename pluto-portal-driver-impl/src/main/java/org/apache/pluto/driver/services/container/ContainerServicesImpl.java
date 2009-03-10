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
package org.apache.pluto.driver.services.container;

import javax.portlet.PortalContext;

import org.apache.pluto.container.OptionalContainerServices;
import org.apache.pluto.container.RequiredContainerServices;
import org.apache.pluto.container.spi.CCPPProfileService;
import org.apache.pluto.container.spi.ContainerInvocationService;
import org.apache.pluto.container.spi.PortalCallbackService;
import org.apache.pluto.container.spi.optional.PortletPreferencesService;
import org.apache.pluto.core.PlutoContainerServices;
import org.apache.pluto.driver.config.DriverConfiguration;

/**
 * The Portal Driver's <code>PortletContainerServices</code> implementation. The
 * <code>PortletContainerServices</code> interface is the main integration point
 * between the pluto container and the surrounding portal.
 * @version 1.0
 * @since Sep 21, 2004
 */
public class ContainerServicesImpl extends PlutoContainerServices implements RequiredContainerServices, OptionalContainerServices 
{
    private DriverConfiguration driverConfig;

    /**
     * Default Constructor.
     */
    public ContainerServicesImpl(PortalContext context,
                                 DriverConfiguration driverConfig,
                                 CCPPProfileService ccppProfileService,
                                 ContainerInvocationService containerInvocation) 
    {
        super(context, ccppProfileService, containerInvocation, driverConfig.getPortalCallbackService());
        this.driverConfig = driverConfig;
    }

    
    /**
     * The PortletPreferencesService provides access to the portal's
     * PortletPreference persistence mechanism.
     * @return a PortletPreferencesService instance.
     */
//    public PortletPreferencesService getPortletPreferencesService() 
//    {
//        return driverConfig.getPortletPreferencesService();
//    }

    /**
     * The PortalCallbackService allows the container to communicate
     * actions back to the portal.
     * @return a PortalCallbackService implementation.
     */
    public PortalCallbackService getPortalCallbackService() 
    {
        return driverConfig.getPortalCallbackService();
    }

}

