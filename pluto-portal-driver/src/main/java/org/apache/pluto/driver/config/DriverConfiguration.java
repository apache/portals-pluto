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
package org.apache.pluto.driver.config;

import org.apache.pluto.driver.services.impl.resource.PortletApplicationConfig;
import org.apache.pluto.driver.services.impl.resource.PortletWindowConfig;
import org.apache.pluto.driver.services.impl.resource.PageConfig;
import org.apache.pluto.services.PortalCallbackService;
import org.apache.pluto.services.optional.PortletPreferencesService;

import javax.servlet.ServletContext;
import java.util.Collection;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @todo Document
 * @since Sep 2, 2005
 */
public interface DriverConfiguration {

    /**
     * Initialization method used to place the driver
     * configuration into service.
     *
     * @param context
     */
    void init(ServletContext context);

    String getPortalName();

    String getPortalVersion();

    String getContainerName();

    Collection getSupportedPortletModes();

    Collection getSupportedWindowStates();

    Collection getPortletApplications();

    PortletApplicationConfig getPortletApp(String id);

    PortletWindowConfig getPortletWindowConfig(String id);

    Collection getPages();

    PageConfig getPageConfig(String pageId);

//
// Utility methods for the container
//
    PortalCallbackService getPortalCallbackService();

    PortletPreferencesService getPortletPreferencesService();
}
