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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.services.PortletRegistryService;
import org.apache.pluto.driver.services.PropertyConfigService;
import org.apache.pluto.driver.services.RenderConfigService;
import org.springframework.beans.factory.xml.XmlBeanFactory;

import javax.servlet.ServletContext;
import java.io.InputStream;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfigurationFactory {

    private static final Log LOG =
        LogFactory.getLog(DriverConfigurationFactory.class);

    private static final String DRIVER_CONFIG =
        "/WEB-INF/pluto-portal-driver-services-config.xml";


    private static DriverConfigurationFactory factory;

    public static DriverConfigurationFactory getFactory() {
        if (factory == null) {
            factory = new DriverConfigurationFactory();
        }
        return factory;
    }

    private DriverConfigurationFactory() {

    }

    public DriverConfiguration getConfig(ServletContext context) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Retrieving driver configuration from: "+DRIVER_CONFIG);
        }

        InputStream in =
            context.getResourceAsStream(DRIVER_CONFIG);

        XmlBeanFactory beanFactory = new XmlBeanFactory(in);

        PropertyConfigService propService = (PropertyConfigService)
            beanFactory.getBean("PropertyConfigService");
        propService.init(context);

        PortletRegistryService registryService = (PortletRegistryService)
            beanFactory.getBean("PortletRegistryService");
        registryService.init(context);

        RenderConfigService renderService = (RenderConfigService)
            beanFactory.getBean("RenderConfigService");
        renderService.init(context);

        if(LOG.isDebugEnabled()) {
            LOG.debug("PropertyConfigService Found: "+propService.getClass().getName());
            LOG.debug("PortletRegistryService Found: "+registryService.getClass().getName());
            LOG.debug("RenderConfigService Found: "+renderService.getClass().getName());
        }

        return new DriverConfiguration(
            propService,
            registryService,
            renderService
        );
    }
}

