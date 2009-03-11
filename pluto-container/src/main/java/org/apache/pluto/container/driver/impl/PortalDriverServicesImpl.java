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
package org.apache.pluto.container.driver.impl;

import javax.portlet.PortalContext;

import org.apache.pluto.container.CCPPProfileService;
import org.apache.pluto.container.EventCoordinationService;
import org.apache.pluto.container.FilterManagerService;
import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.OptionalContainerServices;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.PortletURLListenerService;
import org.apache.pluto.container.RequiredContainerServices;
import org.apache.pluto.container.UserInfoService;
import org.apache.pluto.container.driver.PortalAdministrationService;
import org.apache.pluto.container.driver.PortalDriverContainerServices;
import org.apache.pluto.container.driver.PortalDriverServices;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.impl.PortletEnvironmentServiceImpl;


public class PortalDriverServicesImpl implements PortalDriverServices
{
    /*
     * required services
     */
    private PortalContext context;
    private EventCoordinationService eventCoordinationService;
    private PortletRequestContextService portletRequestContextService;
    private CCPPProfileService ccppProfileService;
    private FilterManagerService filterManagerService;
    private PortletURLListenerService portletURLListenerService;
    
    /*
     * optional services
     */
    private PortletPreferencesService portletPreferencesService;
    private PortletInvokerService portletInvokerService;
    private PortletEnvironmentService portletEnvironmentService;
    private UserInfoService userInfoService;
    private NamespaceMapper namespaceMapper;

    /*
     * portal driver services
     */
    private PortletContextService portletContextService;
    private PortletRegistryService portletRegistryService;
    private PortalAdministrationService portalAdministrationService;
        
    public PortalDriverServicesImpl(PortalContext context,
                                  PortletRequestContextService portletRequestContextService,
                                  EventCoordinationService eventCoordinationService,
                                  FilterManagerService filterManagerService,
                                  PortletURLListenerService portletURLListenerService)
    {
        this.context = context;
        this.eventCoordinationService = eventCoordinationService;
        this.portletRequestContextService = portletRequestContextService;
        this.filterManagerService = filterManagerService;
        this.portletURLListenerService = portletURLListenerService;

        createDefaultServicesIfNeeded();
    }            
                                  
    public PortalDriverServicesImpl(PortalContext context,
            PortletRequestContextService portletRequestContextService,
            EventCoordinationService eventCoordinationService,
            FilterManagerService filterManagerService,
            PortletURLListenerService portletURLListenerService,
            OptionalContainerServices optionalServices,
            PortletContextService portletContextService,
            PortletRegistryService portletRegistryService,
            PortalAdministrationService portalAdministrationService)  
    {
        this.context = context;
        this.eventCoordinationService = eventCoordinationService;
        this.portletRequestContextService = portletRequestContextService;
        this.filterManagerService = filterManagerService;
        this.portletURLListenerService = portletURLListenerService;

        portletEnvironmentService = optionalServices.getPortletEnvironmentService();
        ccppProfileService = optionalServices.getCCPPProfileService();
        portletPreferencesService = optionalServices.getPortletPreferencesService();
        portletInvokerService = optionalServices.getPortletInvokerService();
        userInfoService = optionalServices.getUserInfoService();
        namespaceMapper = optionalServices.getNamespaceMapper();
        
        this.portletContextService = portletContextService;
        this.portletRegistryService = portletRegistryService;        
        this.portalAdministrationService = portalAdministrationService;

        createDefaultServicesIfNeeded();
    }
    
    public PortalDriverServicesImpl(RequiredContainerServices required, OptionalContainerServices optional)
    {
        this(required.getPortalContext(), required.getPortletRequestContextService(),
             required.getEventCoordinationService(), required.getFilterManagerService(), 
             required.getPortletURLListenerService(), optional, null, null, null);
    }

    public PortalDriverServicesImpl(RequiredContainerServices required, OptionalContainerServices optional, PortalDriverContainerServices driver)
    {
        this(required.getPortalContext(), required.getPortletRequestContextService(),
             required.getEventCoordinationService(), required.getFilterManagerService(), 
             required.getPortletURLListenerService(), optional, 
             driver.getPortletContextService(), driver.getPortletRegistryService(), 
             driver.getPortalAdministrationService());
    }

    protected void createDefaultServicesIfNeeded()
    {
        portletRegistryService = portletRegistryService == null ? new PortletContextManager() : portletRegistryService;
        portletContextService = portletContextService == null ? (PortletContextManager)portletRegistryService : portletContextService;
        portalAdministrationService = portalAdministrationService == null ? new DefaultPortalAdministrationService() : portalAdministrationService;
        ccppProfileService = ccppProfileService == null ? new DummyCCPPProfileServiceImpl() : ccppProfileService;
        portletPreferencesService = portletPreferencesService == null ? new DefaultPortletPreferencesService() : portletPreferencesService;
        portletInvokerService = portletInvokerService == null ? new DefaultPortletInvokerService(portletContextService) : portletInvokerService;
        portletEnvironmentService = portletEnvironmentService == null ? new PortletEnvironmentServiceImpl() : portletEnvironmentService;
        userInfoService = userInfoService == null ? new DefaultUserInfoService() : userInfoService;
        namespaceMapper = namespaceMapper == null ? new DefaultNamespaceMapper() : namespaceMapper;
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

    public PortletURLListenerService getPortletURLListenerService()
    {
        return portletURLListenerService;
    }    
}
