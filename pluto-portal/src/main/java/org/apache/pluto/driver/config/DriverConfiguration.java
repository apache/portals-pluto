/*
 * Copyright 2004 The Apache Software Foundation.
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

import org.apache.pluto.driver.services.PortletRegistryService;
import org.apache.pluto.driver.services.PropertyConfigService;
import org.apache.pluto.driver.services.RenderConfigService;
import org.apache.pluto.driver.services.impl.resource.PortletApplicationConfig;
import org.apache.pluto.driver.services.impl.resource.PortletWindowConfig;
import org.apache.pluto.driver.services.impl.resource.PageConfig;

import java.util.Collection;

/**
 * Encapsulation of the Pluto Driver Configuration.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfiguration {

    private PropertyConfigService propertyService;
    private PortletRegistryService registryService;
    private RenderConfigService renderService;

    public DriverConfiguration(PropertyConfigService propertyService,
                               PortletRegistryService registryService,
                               RenderConfigService renderService) {
        this.propertyService = propertyService;
        this.registryService = registryService;
        this.renderService = renderService;
    }

    /**
     * Standard Getter.
     * @return the name of the portal.
     */
    public String getPortalName() {
        return propertyService.getPortalName();
    }

    /**
     * Standard Getter.
     * @return the portal version.
     */
    public String getPortalVersion() {
        return propertyService.getPortalVersion();
    }

    /**
     * Standard Getter.
     * @return the name of the container.
     */
    public String getContainerName() {
        return propertyService.getContainerName();
    }

    /**
     * Standard Getter.
     * @return the names of the supported portlet modes.
     */
    public Collection getSupportedPortletModes() {
        return propertyService.getSupportedPortletModes();
    }

    /**
     * Standard Getter.
     * @return the names of the supported window states.
     */
    public Collection getSupportedWindowStates() {
        return propertyService.getSupportedWindowStates();
    }

    /**
     * Standard Getter.
     * @return the configuration data of all configured portlet applications.
     */
    public Collection getPortletApplications() {
        return registryService.getPortletApplications();
    }

   /**
     * Retrieve the portlet application with the given id.
     * @param id the id of the portlet application.
     * @return the portlet application configuration data.
     */
    public PortletApplicationConfig getPortletApp(String id) {
        return registryService.getPortletApplication(id);
    }

    /**
     * Retrieve the window configuration associated with the given id.
     * @param id the id of the portlet window.
     * @return the portlet window configuration data.
     */
    public PortletWindowConfig getPortletWindowConfig(String id) {
        return registryService.getPortlet(id);
    }

    /**
     * Standard Getter.
     * @return the render configuration.
     */
    public Collection getPages() {
        return renderService.getPages();
    }

    public PageConfig getPageConfig(String pageId) {
        return renderService.getPage(pageId);
    }
}

