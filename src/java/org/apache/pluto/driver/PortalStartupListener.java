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
package org.apache.pluto.driver;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletContainerFactory;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.config.DriverConfigurationFactory;
import org.apache.pluto.driver.services.ContainerServicesImpl;
import org.apache.pluto.driver.services.PortalContextImpl;
import org.xml.sax.SAXException;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalStartupListener implements ServletContextListener {
    private static final Log LOG =
        LogFactory.getLog(PortalStartupListener.class);

    private static final String CONFIG_FILE =
        "/WEB-INF/pluto-portal-driver-config.xml";

    private static final String CONTAINER_KEY = AttributeKeys.PORTLET_CONTAINER;

    private static final String CONFIG_KEY = AttributeKeys.DRIVER_CONFIG;


    public void contextInitialized(ServletContextEvent event) {
        ServletContext ctx = event.getServletContext();
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Starting Pluto Portal Driver. . .");
            }
            InputStream in = ctx.getResourceAsStream(CONFIG_FILE);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" - Reading Configuration. . .");
            }
            DriverConfiguration config =
                DriverConfigurationFactory.getFactory().parse(in);

            if (LOG.isDebugEnabled()) {
                LOG.debug(
                    " - Creating Portal Context [" + config.getPortalName() +
                    "/" +
                    config.getPortalVersion() +
                    "]. . .");
            }

            PortalContextImpl context = new PortalContextImpl(config);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" - Creating Container Services. . .");
            }

            ContainerServicesImpl impl = new ContainerServicesImpl(context);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" - Creating Portlet Container. . .");
            }

            PortletContainerFactory factory = PortletContainerFactory.getInstance();
            PortletContainer container = factory.createContainer(
                config.getContainerName(), impl);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" - Starting Portlet Container");
            }

            container.init(ctx);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" Pluto Portal Driver Started.");
            }

            ctx.setAttribute(CONFIG_KEY, config);
            ctx.setAttribute(CONTAINER_KEY, container);
        } catch (IOException io) {
            LOG.error(
                "Unable to start portal.  Configuration not found at '" +
                CONFIG_FILE +
                "'.",
                io);
        } catch (SAXException sax) {
            LOG.error(
                "Unable to start portal.  Invalid configuration found at '" +
                CONFIG_FILE +
                "'.",
                sax);
        } catch (PortletContainerException exception) {
            LOG.error("Unable to start portlet container. ", exception);
        }
    }

    public void contextDestroyed(ServletContextEvent event) {
        ServletContext ctx = event.getServletContext();
        PortletContainer container =
            (PortletContainer) ctx.getAttribute(CONTAINER_KEY);

        try {
            container.destroy();
        } catch (PortletContainerException exc) {
            LOG.error("Unable to shutdown portlet container. ", exc);
        } finally {
            ctx.removeAttribute(CONTAINER_KEY);
        }
    }


}

