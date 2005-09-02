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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletContainerFactory;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.config.DriverConfigurationFactory;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.container.ContainerServicesImpl;
import org.apache.pluto.driver.services.container.PortalContextImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener used to start up the Pluto Portal Driver upon
 * startup of the servlet context in which it resides.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalStartupListener implements ServletContextListener {
    /** Internal Logger. */
    private static final Log LOG =
        LogFactory.getLog(PortalStartupListener.class);

    /**  The location of the portal driver configuration. */

    /** The KEY with which the container is bound to the context. */
    private static final String CONTAINER_KEY = AttributeKeys.PORTLET_CONTAINER;

    /** The KEY with which the configuration is bound to the context. */
    private static final String CONFIG_KEY = AttributeKeys.DRIVER_CONFIG;


    /**
     * Receive the startup notification and subsequently start up
     * the portal driver. The following are done in this order:
     * <ol><li>Retrieve the Configuration File</li>
     *     <li>Parse the Configuration File into Configuration Objects</li>
     *     <li>Create a Portal Context</li>
     *     <li>Create the ContainerServices implementation</li>
     *     <li>Create the Portlet Container</li>
     *     <li>Initialize the Container</li>
     *     <li>Bind the configuration to the ServletContext</li>
     *     <li>Bind the container to the ServletContext</li><ul>
     *
     * @param event the servlet context event.
     */
    public void contextInitialized(ServletContextEvent event) {
        ServletContext ctx = event.getServletContext();
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Starting Pluto Portal Driver . . .");
                LOG.debug(" - Retreaving Driver Configuration . . .");
            }

            DriverConfiguration config =
                DriverConfigurationFactory.getFactory().getConfig(ctx);

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
            PortletContainer container =
                factory.createContainer(
                    config.getContainerName(),
                    impl
                );

            if (LOG.isDebugEnabled()) {
                LOG.debug(" - Starting Portlet Container");
            }

            container.init(ctx);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" Pluto Portal Driver Started.");
            }

            ctx.setAttribute(CONFIG_KEY, config);
            ctx.setAttribute(CONTAINER_KEY, container);

        } catch (DriverConfigurationException exception) {
            LOG.error(
                "Unable to retrieve driver configuration due to configuration error.",
                exception
            );
        } catch (PortletContainerException exception) {
            LOG.error(
                "Unable to start portlet container due to configuration error.",
                exception
            );
        }
    }

    /**
     * Recieve notification that the context is being shut down
     * and subsequently destroy the container.
     *
     * @param event the destrubtion even.t
     */
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

