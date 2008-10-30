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
package org.apache.pluto.core;

import javax.portlet.PortalContext;

import org.apache.pluto.NamespaceMapper;
import org.apache.pluto.OptionalContainerServices;
import org.apache.pluto.RequiredContainerServices;
import org.apache.pluto.services.ContainerServices;
import org.apache.pluto.spi.CCPPProfileService;
import org.apache.pluto.spi.ContainerInvocationService;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.spi.optional.PortalAdministrationService;
import org.apache.pluto.spi.optional.PortletEnvironmentService;
import org.apache.pluto.spi.optional.PortletInfoService;
import org.apache.pluto.spi.optional.PortletInvokerService;
import org.apache.pluto.spi.optional.PortletPreferencesService;
import org.apache.pluto.spi.optional.PortletRegistryService;
import org.apache.pluto.spi.optional.RequestAttributeService;
import org.apache.pluto.spi.optional.UserInfoService;


public class PlutoContainerServices implements ContainerServices
{
    /*
     * required services
     */
    private PortalContext context;
    private CCPPProfileService ccppProfileService;
    private PortalCallbackService callbackService;
    private ContainerInvocationService containerInvocation;
    
    /*
     * optional services
     */
    private PortletPreferencesService portletPreferencesService;
    private PortletRegistryService portletRegistryService;
    private PortletInvokerService portletInvokerService;
    private PortletEnvironmentService portletEnvironmentService;
    private PortletInfoService portletInfoService;
    private PortalAdministrationService portalAdministrationService;
    private UserInfoService userInfoService;
    private RequestAttributeService requestAttributeService;
    private NamespaceMapper namespaceMapper;
        
    public PlutoContainerServices()
    {
        createDefaultRequiredServices();
        createDefaultOptionalServices();
    }
    
    public PlutoContainerServices(RequiredContainerServices required, OptionalContainerServices optional)
    {
        this(required.getPortalContext(), required.getCCPPProfileService(), required.getContainerInvocationService(), required.getPortalCallbackService(), optional);
    }

    public PlutoContainerServices(PortalContext context,
            CCPPProfileService ccppProfileService,
            ContainerInvocationService containerInvocation,
            PortalCallbackService callbackService)
    {
        this.context = context;
        this.ccppProfileService = ccppProfileService;
        this.containerInvocation = containerInvocation;
        this.callbackService = callbackService;
        this.createDefaultOptionalServices();
    }            
            
    public PlutoContainerServices(PortalContext context,
            CCPPProfileService ccppProfileService,
            ContainerInvocationService containerInvocation,
            PortalCallbackService callbackService,            
            OptionalContainerServices optionalServices)            
    {
        this.context = context;
        this.ccppProfileService = ccppProfileService;
        this.containerInvocation = containerInvocation;
        
        portletPreferencesService = optionalServices.getPortletPreferencesService();
        if (portletPreferencesService == null)
            portletPreferencesService =  new DefaultPortletPreferencesService();
        portletRegistryService = optionalServices.getPortletRegistryService();
        if (portletRegistryService == null)
            portletRegistryService = new PortletContextManager();
        portletInvokerService = optionalServices.getPortletInvokerService();
        if (portletInvokerService == null)
            portletInvokerService = new DefaultPortletInvokerService();
        portletEnvironmentService = optionalServices.getPortletEnvironmentService();
        if (portletEnvironmentService == null)
            portletEnvironmentService = new DefaultPortletEnvironmentService();
        portletInfoService = optionalServices.getPortletInfoService();
        if (portletInfoService == null)
            portletInfoService = new DefaultPortletInfoService();
        portalAdministrationService = optionalServices.getPortalAdministrationService();
        if (portalAdministrationService == null)
            portalAdministrationService = new DefaultPortalAdministrationService();
        userInfoService = optionalServices.getUserInfoService();
        if (userInfoService == null)
            userInfoService = new DefaultUserInfoService();
        requestAttributeService = optionalServices.getRequestAttributeService();
        if (requestAttributeService == null)
            requestAttributeService = new DefaultRequestAttributeService(optionalServices.getNamespaceMapper(), optionalServices.getUserInfoService());
        namespaceMapper = optionalServices.getNamespaceMapper();
        if (namespaceMapper == null)
            namespaceMapper = new DefaultNamespaceMapper();
    }
    
    protected void createDefaultOptionalServices() 
    {
        portletPreferencesService = new DefaultPortletPreferencesService();
        portletRegistryService = new PortletContextManager();

        portletInvokerService = new DefaultPortletInvokerService();
        portletEnvironmentService = new DefaultPortletEnvironmentService();
        portletInfoService = new DefaultPortletInfoService();
        portalAdministrationService = new DefaultPortalAdministrationService();
        userInfoService = new DefaultUserInfoService();
        namespaceMapper = new DefaultNamespaceMapper();
        requestAttributeService = new DefaultRequestAttributeService(namespaceMapper, userInfoService);
    }

    protected void createDefaultRequiredServices() 
    {
        context = null; // TODO
        ccppProfileService = new DummyCCPPProfileServiceImpl();
        callbackService = null; // TODO
        containerInvocation = new ContainerInvocationServiceImpl();        
    }
    
    public PortalContext getPortalContext() 
    {
        return context;
    }

    public ContainerInvocationService getContainerInvocationService()
    {
        return containerInvocation;
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
     * The PortalCallbackService allows the container to communicate
     * actions back to the portal.
     * @return a PortalCallbackService implementation.
     */
    public PortalCallbackService getPortalCallbackService() 
    {
        return callbackService;
    }


    /**
     * Returns null to use pluto's default
     * @return
     */
    public PortletRegistryService getPortletRegistryService() 
    {
        return this.portletRegistryService;
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

    public PortletInfoService getPortletInfoService() 
    {
        return this.portletInfoService;
    }

    public PortalAdministrationService getPortalAdministrationService() 
    {
        return this.portalAdministrationService;
    }

    public UserInfoService getUserInfoService() 
    {
        return this.userInfoService;
    }
    
    public RequestAttributeService getRequestAttributeService() 
    {
        return this.requestAttributeService;
    }
    
    public NamespaceMapper getNamespaceMapper() 
    {
        return this.namespaceMapper;
    }
}
