/*
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.pluto.driver.services.portal;

import java.util.Set;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since Aug 10, 2005
 */
public interface PortletRegistryService extends DriverConfigurationService {

    /**
     * A set of all Portlet Applications
     * @return a set of uniqe PortletAppConfig instances.
     */
    public Set getPortletApplications();

    /**
     * Retrieves the PortletAppConfig associated
     * with the specified id.
     * @param id the unique id of the portlet application config
     * @return the PortletAppConfig instance for the specified id.
     */
    public PortletApplicationConfig getPortletApplication(String id);

    /**
     * Utility method used to retrieve a portlet
     * directly from the service to prevent the driver
     * from needing to navigate the portlet application
     * object graph.
     *
     * @param id the unique id of the portlet being requested.
     * @return PortletWindowConfig for the specified id.
     */
    public PortletWindowConfig getPortlet(String id);

}
