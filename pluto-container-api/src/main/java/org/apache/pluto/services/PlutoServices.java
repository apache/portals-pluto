package org.apache.pluto.services;

import javax.portlet.PortalContext;

import org.apache.pluto.NamespaceMapper;
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


public class PlutoServices implements ContainerServices
{
    private ContainerServices provider;
    private static PlutoServices singleton;

    public static ContainerServices getServices()
    {
        return singleton;
    }
    
    public PlutoServices(ContainerServices provider)
    {
        singleton = this;
        this.provider = provider;
    }
    public CCPPProfileService getCCPPProfileService()
    {
        return provider.getCCPPProfileService();
    }

    public ContainerInvocationService getContainerInvocationService()
    {
        return provider.getContainerInvocationService();
    }

    public PortalCallbackService getPortalCallbackService()
    {
        return provider.getPortalCallbackService();
    }

    public PortalContext getPortalContext()
    {
        return provider.getPortalContext();
    }

    public NamespaceMapper getNamespaceMapper()
    {
        return provider.getNamespaceMapper();
    }

    public PortalAdministrationService getPortalAdministrationService()
    {
        return provider.getPortalAdministrationService();
    }

    public PortletEnvironmentService getPortletEnvironmentService()
    {
        return provider.getPortletEnvironmentService();
    }

    public PortletInfoService getPortletInfoService()
    {
        return provider.getPortletInfoService();
    }

    public PortletInvokerService getPortletInvokerService()
    {
        return provider.getPortletInvokerService();
    }

    public PortletPreferencesService getPortletPreferencesService()
    {
        return provider.getPortletPreferencesService();
    }

    public PortletRegistryService getPortletRegistryService()
    {
        return provider.getPortletRegistryService();
    }

    public RequestAttributeService getRequestAttributeService()
    {
        return provider.getRequestAttributeService();
    }

    public UserInfoService getUserInfoService()
    {
        return provider.getUserInfoService();
    }

}
