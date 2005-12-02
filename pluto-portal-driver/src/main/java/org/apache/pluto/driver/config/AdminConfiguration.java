package org.apache.pluto.driver.config;

import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.driver.services.portal.admin.RenderConfigAdminService;

import javax.servlet.ServletContext;

/**
 * Interface defining a means for obtaining administrative
 * services for portal configuration.  An implementation
 * of this interface will be bound to the portal's
 * ServletContext IF administrative functions are
 * supported by the current implementation.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 30, 2005
 */
public interface AdminConfiguration {

    /**
     * Initialize the configuration
     * @param context
     */
    void init(ServletContext context);

    /**
     * Retrieve the administrative service for managing the
     * portlet registry.
     *
     * @return the service if one has been provided
     */
    PortletRegistryAdminService getPortletRegistryAdminService();

    /**
     * Retrieve the administrative service for managing the
     * render configuration.
     * @return the service if one has been provided
     */
    RenderConfigAdminService getRenderConfigAdminService();


}
