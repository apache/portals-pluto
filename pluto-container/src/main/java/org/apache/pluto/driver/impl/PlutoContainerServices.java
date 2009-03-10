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
package org.apache.pluto.driver.impl;

import javax.portlet.PortalContext;

import org.apache.pluto.container.CCPPProfileService;
import org.apache.pluto.container.ContainerServices;
import org.apache.pluto.container.EventCoordinationService;
import org.apache.pluto.container.FilterManagerService;
import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.OptionalContainerServices;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.PortletURLListener;
import org.apache.pluto.container.RequiredContainerServices;
import org.apache.pluto.container.UserInfoService;
import org.apache.pluto.container.driver.PortalAdministrationService;
import org.apache.pluto.container.driver.PortalDriverServices;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletRegistryService;


public class PlutoContainerServices implements ContainerServices, PortalDriverServices
{
    /*
     * required services
     */
    private PortalContext context;
    private CCPPProfileService ccppProfileService;
    
    /*
     * optional services
     */
    private PortletPreferencesService portletPreferencesService;
    private PortletRegistryService portletRegistryService;
    private PortletContextService portletContextService;
    private PortletInvokerService portletInvokerService;
    private PortletRequestContextService portletRequestContextService;
    private PortletEnvironmentService portletEnvironmentService;
    private PortalAdministrationService portalAdministrationService;
    private UserInfoService userInfoService;
    private NamespaceMapper namespaceMapper;
    private EventCoordinationService eventCoordinationService;
    private FilterManagerService filterManagerService;
    private PortletURLListener portletURLListener;

        
    public PlutoContainerServices()
    {
        createDefaultPortalDriverServices();
        createDefaultRequiredServices();
        createDefaultOptionalServices();
    }
    
    public PlutoContainerServices(RequiredContainerServices required, OptionalContainerServices optional)
    {
        this(required.getPortalContext(), required.getPortletRequestContextService(),
             required.getEventCoordinationService(), required.getFilterManagerService(), 
             required.getPortletURLListener(), optional,
             optional instanceof PortalDriverServices ? (PortalDriverServices) optional : null);
    }

    public PlutoContainerServices(PortalContext context,
            PortletRequestContextService portletRequestContextService,
            FilterManagerService filterManagerService,
            PortletURLListener portletURLListener,
            EventCoordinationService eventCoordinationService)
    {
        this.context = context;
        this.eventCoordinationService = eventCoordinationService;
        this.createDefaultPortalDriverServices();
        this.createDefaultOptionalServices();
    }            
            
    public PlutoContainerServices(PortalContext context,
            PortletRequestContextService portletRequestContextService,
            EventCoordinationService eventCoordinationService,
            FilterManagerService filterManagerService,
            PortletURLListener portletURLListener,
            OptionalContainerServices optionalServices,
            PortalDriverServices portalDriverServices)  
    {
        this.context = context;
        this.portletRequestContextService = portletRequestContextService;
        this.filterManagerService = filterManagerService;
        this.portletURLListener = portletURLListener;
        ccppProfileService = optionalServices.getCCPPProfileService();
        if (ccppProfileService == null)
            ccppProfileService = new DummyCCPPProfileServiceImpl();
        this.eventCoordinationService = eventCoordinationService;
        
        portletPreferencesService = optionalServices.getPortletPreferencesService();
        if (portletPreferencesService == null)
            portletPreferencesService =  new DefaultPortletPreferencesService();
        portletRegistryService = portalDriverServices != null ? portalDriverServices.getPortletRegistryService() : null;
        if (portletRegistryService == null)
            portletRegistryService = new PortletContextManager();
        portletContextService = portalDriverServices != null ? portalDriverServices.getPortletContextService() : null;
        if (portletContextService == null && portletRegistryService instanceof PortletContextService)
        {
            portletContextService = (PortletContextService)portletRegistryService;
        }
        portletInvokerService = optionalServices.getPortletInvokerService();
        if (portletInvokerService == null)
            portletInvokerService = new DefaultPortletInvokerService(portletContextService);
        portletEnvironmentService = optionalServices.getPortletEnvironmentService();
        if (portletEnvironmentService == null)
            portletEnvironmentService = new DefaultPortletEnvironmentService();
        portalAdministrationService = portalDriverServices != null ? portalDriverServices.getPortalAdministrationService() : null;
        if (portalAdministrationService == null)
            portalAdministrationService = new DefaultPortalAdministrationService();
        userInfoService = optionalServices.getUserInfoService();
        if (userInfoService == null)
            userInfoService = new DefaultUserInfoService();
        namespaceMapper = optionalServices.getNamespaceMapper();
        if (namespaceMapper == null)
            namespaceMapper = new DefaultNamespaceMapper();
    }
    
    protected void createDefaultPortalDriverServices()
    {
        portletRegistryService = new PortletContextManager();
        portletContextService = (PortletContextManager)portletRegistryService;
        portalAdministrationService = new DefaultPortalAdministrationService();
    }
    
    protected void createDefaultOptionalServices() 
    {
        ccppProfileService = new DummyCCPPProfileServiceImpl();
        portletPreferencesService = new DefaultPortletPreferencesService();
        portletInvokerService = new DefaultPortletInvokerService(portletContextService);
        portletEnvironmentService = new DefaultPortletEnvironmentService();
        userInfoService = new DefaultUserInfoService();
        namespaceMapper = new DefaultNamespaceMapper();
    }

    protected void createDefaultRequiredServices() 
    {
        this.context = null; // TODO
        this.portletRequestContextService = null; // TODO
        this.eventCoordinationService = null; // TODO
        this.filterManagerService = null; // TODO
        this.portletURLListener = null; // TODO
    }
    
    public PortalContext getPortalContext() 
    {
        return context;
    }

    /**
     * The PortletPreferencesService provides access to the portal's
     * PortletPreference persistence mechanism.
     * @return a PortletPreferencesService instance.
     */
    public PortletPreferencesService getPortletPreferencesService() 
    {
        return this.portletPreferencesService;
    }

    /**
     * Returns null to use pluto's default
     * @return
     */
    public PortletRegistryService getPortletRegistryService() 
    {
        return this.portletRegistryService;
    }

    public PortletContextService getPortletContextService() 
    {
        return this.portletContextService;
    }

    public PortletRequestContextService getPortletRequestContextService() 
    {
        return this.portletRequestContextService;
    }

    public PortletEnvironmentService getPortletEnvironmentService() 
    {
        return this.portletEnvironmentService;
    }

    public PortletInvokerService getPortletInvokerService() 
    {
        return this.portletInvokerService;
    }

    public CCPPProfileService getCCPPProfileService() 
    {
        return ccppProfileService;
    }

    public PortalAdministrationService getPortalAdministrationService() 
    {
        return this.portalAdministrationService;
    }

    public UserInfoService getUserInfoService() 
    {
        return this.userInfoService;
    }
    
    public NamespaceMapper getNamespaceMapper() 
    {
        return this.namespaceMapper;
    }

    public CCPPProfileService getCcppProfileService()
    {
        return ccppProfileService;
    }

    public EventCoordinationService getEventCoordinationService()
    {
        return eventCoordinationService;
    }

    public FilterManagerService getFilterManagerService()
    {
        return filterManagerService;
    }

    public PortletURLListener getPortletURLListener()
    {
        return portletURLListener;
    }    
}
