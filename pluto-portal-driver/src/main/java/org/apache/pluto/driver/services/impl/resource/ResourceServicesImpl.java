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
package org.apache.pluto.driver.services.impl.resource;

import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.config.impl.PortletRegistryService;
import org.apache.pluto.driver.config.impl.PropertyConfigService;
import org.apache.pluto.driver.config.impl.RenderConfigService;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Set;
import java.io.InputStream;

/**
 * Default implementation of all of the portal Services.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @since Aug 10, 2005
 */
public class ResourceServicesImpl implements
    PropertyConfigService, PortletRegistryService, RenderConfigService {

    private static final String CONFIG_FILE =
        "/WEB-INF/pluto-portal-driver-config.xml";

    private Configuration config;

//
// Lifecycle Methods
//
    /**
     * Initialization Lifecycle Method
     * @param ctx
     */
    public void init(ServletContext ctx) {
        // because we comprise 3 services, we must
        // prevent reinitialization.
        if(config != null)
            return;

        try {
            InputStream in = ctx.getResourceAsStream(CONFIG_FILE);
            config = ConfigurationFactory.getFactory().parse(in);
        }
        catch(Exception e) {
            throw new DriverConfigurationException(e);
        }
    }

    /**
     * Shutdown the ResourceService.
     */
    public void destroy() {
        config = null;
    }


    public String getPortalName() {
        return config.getPortalName();
    }

    public String getPortalVersion() {
        return config.getPortalVersion();
    }

    public String getContainerName() {
        return config.getContainerName();
    }

    public Set getSupportedPortletModes() {
        return config.getSupportedPortletModes();
    }

    public Set getSupportedWindowStates() {
        return config.getSupportedWindowStates();
    }

    public Set getPortletApplications() {
        return config.getPortletApplications();
    }

    public PortletApplicationConfig getPortletApplication(String id) {
        return config.getPortletApp(id);
    }

    public PortletWindowConfig getPortletWindowConfig(String id) {
        return config.getPortletWindowConfig(id);
    }

    public PortletWindowConfig getPortlet(String id) {
        return config.getPortletWindowConfig(id);
    }

    public List getPages() {
        return config.getRenderConfig().getPages();
    }

    public PageConfig getDefaultPage() {
        return config.getRenderConfig().getPageConfig(null);
    }

    public PageConfig getPage(String id) {
        return config.getRenderConfig().getPageConfig(id);
    }

}
