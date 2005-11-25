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
import org.apache.pluto.driver.services.portal.*;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Set;
import java.io.InputStream;

/**
 * Default implementation of all of the portal Services.
 * Utilizes resource configuration from
 * <code>pluto-portal-driver-config.xml</code>
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @since Aug 10, 2005
 */
public class PortletRegistryServiceImpl implements PortletRegistryService {

    private ResourceConfig config;

    public PortletRegistryServiceImpl() {
        
    }

    /**
     * Initialization Lifecycle Method
     * @param ctx
     */
    public void init(ServletContext ctx) {
        try {
            InputStream in = ctx.getResourceAsStream(ResourceConfigReader.CONFIG_FILE);
            config = ResourceConfigReader.getFactory().parse(in);
        }
        catch(Exception e) {
            throw new DriverConfigurationException(e);
        }
    }

    public void destroy() throws DriverConfigurationException {
        config = null;
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

}
