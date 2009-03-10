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

import javax.portlet.PortalContext;

import org.apache.pluto.container.CCPPProfileService;
import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.EventCoordinationService;
import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortalCallbackService;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.UserInfoService;


public class PlutoServices implements ContainerServices, PortalDriverServices
{
    private ContainerServices containerServices;
    private PortalDriverServices driverServices;
    
    private static PlutoServices singleton;

    public static PlutoServices getServices()
    {
        return singleton;
    }
    
    public PlutoServices(ContainerServices containerServices, PortalDriverServices driverServices)
    {
        singleton = this;
        this.containerServices = containerServices;
        this.driverServices = driverServices;
    }
    
    public CCPPProfileService getCCPPProfileService()
    {
        return containerServices.getCCPPProfileService();
    }

    public PortalCallbackService getPortalCallbackService()
    {
        return containerServices.getPortalCallbackService();
    }

    public PortalContext getPortalContext()
    {
        return containerServices.getPortalContext();
    }

    public NamespaceMapper getNamespaceMapper()
    {
        return containerServices.getNamespaceMapper();
    }

    public PortalAdministrationService getPortalAdministrationService()
    {
        return driverServices.getPortalAdministrationService();
    }

    public PortletEnvironmentService getPortletEnvironmentService()
    {
        return containerServices.getPortletEnvironmentService();
    }

    public PortletInvokerService getPortletInvokerService()
    {
        return containerServices.getPortletInvokerService();
    }

    public PortletPreferencesService getPortletPreferencesService()
    {
        return containerServices.getPortletPreferencesService();
    }

    public PortletRegistryService getPortletRegistryService()
    {
        return driverServices.getPortletRegistryService();
    }

    public UserInfoService getUserInfoService()
    {
        return containerServices.getUserInfoService();
    }
    
    public PortletContextService getPortletContextService()
    {
        return driverServices.getPortletContextService();
    }

    public PortletRequestContextService getPortletRequestContextService()
    {
        return containerServices.getPortletRequestContextService();
    }

    public EventCoordinationService getEventCoordinationService()
    {
        return containerServices.getEventCoordinationService();
    }
}
