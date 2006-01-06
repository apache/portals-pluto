package org.apache.pluto.driver.services.portal.admin;

import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.config.DriverConfigurationException;

/**
 *
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>:
 * @version 1.0
 * @since Nov 30, 2005
 */
public interface RenderConfigAdminService {

    public void addPage(PageConfig config)
        throws DriverConfigurationException;

}
