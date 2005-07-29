package org.apache.pluto.services;

import javax.portlet.PortalContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Defines the services necessary for integration between the Pluto Container
 * and a Portal.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public interface PortletContainerServices {

    /**
     * Provider used to retrieve request-time services.
     * @param req
     * @return a DynamicInformationProvider implementation.
     */
    DynamicInformationProvider getDynamicInformationProvider(
        HttpServletRequest req);

    /**
     * Return the PortletPreferencesFactory implementation.
     * @return a PortletPreferencesFactory implementation.
     */
    PortletPreferencesFactory getPortletPreferencesFactory();

    /**
     * Retrieve the PortalContext associated with this group of container
     * services.
     * @return a PortalContext implementation.
     */
    PortalContext getPortalContext();

    /**
     * @return a PortalCallbackProvider implementation.
     */
    PortalCallbackProvider getPortalCallbackProvider();

    /**
     * @return a PropertyManagerService implementation.
     */
    PropertyManagerService getPropertyManagerService();
}
