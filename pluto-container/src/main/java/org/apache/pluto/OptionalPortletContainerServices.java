package org.apache.pluto;

import org.apache.pluto.services.PortletPreferencesService;

/**
 * Defines the services necessary for integration between the Pluto Container
 * and a Portal.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public interface OptionalPortletContainerServices {

    PortletPreferencesService getPortletPreferencesService();

}
