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
 * Listener used to start up / shut down the Pluto Portal Driver upon startup /
 * showdown of the servlet context in which it resides.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version $Revision$ $Date$
 * @since Sep 22, 2004
 */
public class PortalStartupListener implements ServletContextListener {
    
    /** Internal logger. */
    private static final Log LOG = LogFactory.getLog(
            PortalStartupListener.class);

    /** The KEY with which the container is bound to the context. */
    private static final String CONTAINER_KEY = AttributeKeys.PORTLET_CONTAINER;

    /** The KEY with which the configuration is bound to the context. */
    private static final String CONFIG_KEY = AttributeKeys.DRIVER_CONFIG;


    /**
     * Receive the startup notification and subsequently start up the portal
     * driver. The following are done in this order:
     * <ol>
     *   <li>Retrieve the Configuration File</li>
     *   <li>Parse the Configuration File into Configuration Objects</li>
     *   <li>Create a Portal Context</li>
     *   <li>Create the ContainerServices implementation</li>
     *   <li>Create the Portlet Container</li>
     *   <li>Initialize the Container</li>
     *   <li>Bind the configuration to the ServletContext</li>
     *   <li>Bind the container to the ServletContext</li>
     * <ol>
     *
     * @param event  the servlet context event.
     */
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        try {
            if (LOG.isInfoEnabled()) {
                LOG.info("Starting up Pluto Portal Driver...");
            }
            
            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Retreaving portal driver configuration...");
            }
            DriverConfiguration config = DriverConfigurationFactory
                    .getFactory().getConfig(servletContext);
            
            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Creating portal context ["
                        + config.getPortalName() + "/"
                        + config.getPortalVersion() + "]...");
            }
            PortalContextImpl portalContext = new PortalContextImpl(config);
            
            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Creating container services...");
            }
            ContainerServicesImpl containerServices =
                    new ContainerServicesImpl(portalContext);
            
            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Creating portlet container...");
            }
            PortletContainerFactory factory =
                    PortletContainerFactory.getInstance();
            PortletContainer container = factory.createContainer(
                    config.getContainerName(),
                    containerServices);

            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Initializing portlet container...");
            }
            container.init(servletContext);
            
            if (LOG.isInfoEnabled()) {
                LOG.info("Pluto Portal Driver started.");
            }
            
            servletContext.setAttribute(CONFIG_KEY, config);
            servletContext.setAttribute(CONTAINER_KEY, container);

        } catch (DriverConfigurationException ex) {
            LOG.error("Unable to retrieve driver configuration "
                    + "due to configuration error: " + ex.getMessage(), ex);
        } catch (PortletContainerException ex) {
            LOG.error("Unable to start up portlet container: "
                    + ex.getMessage(), ex);
        }
    }

    /**
     * Recieve notification that the context is being shut down and subsequently
     * destroy the container.
     *
     * @param event the destrubtion event.
     */
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        PortletContainer container = (PortletContainer)
                servletContext.getAttribute(CONTAINER_KEY);
        if (container != null) {
            try {
                if (LOG.isInfoEnabled()) {
                    LOG.info("Shutting down Pluto Portal Driver...");
                }
                container.destroy();
                if (LOG.isInfoEnabled()) {
                    LOG.info("Pluto Portal Driver shut down.");
                }
            } catch (PortletContainerException ex) {
                LOG.error("Unable to shut down portlet container: "
                        + ex.getMessage(), ex);
            } finally {
                servletContext.removeAttribute(CONTAINER_KEY);
            }
        }
    }
}

