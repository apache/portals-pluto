package org.apache.pluto.driver.services.portal.admin;

import org.apache.pluto.driver.services.portal.PortletApplicationConfig;

/**
 * TODO JavaDoc
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 30, 2005
 */
public interface PortletRegistryAdminService {

    void addPortletApplication(PortletApplicationConfig app) throws DriverAdministrationException;

}
