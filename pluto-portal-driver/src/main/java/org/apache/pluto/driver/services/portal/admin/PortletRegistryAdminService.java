package org.apache.pluto.driver.services.portal.admin;

/**
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Nov 30, 2005
 */
public interface PortletRegistryAdminService {

    public void addPortletApplication(String portletContext)
    throws DriverAdministrationException;

}
