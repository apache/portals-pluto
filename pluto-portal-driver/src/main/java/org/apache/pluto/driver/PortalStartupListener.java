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
import org.apache.pluto.driver.config.AdminConfiguration;
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

    private static final String ADMIN_KEY = AttributeKeys.DRIVER_ADMIN_CONFIG;

    /**
     * Receive the startup notification and subsequently start up the portal
     * driver. The following are done in this order:
     * <ol>
     *   <li>Retrieve the ResourceConfig File</li>
     *   <li>Parse the ResourceConfig File into ResourceConfig Objects</li>
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

        if (LOG.isInfoEnabled()) {
            LOG.info("Starting up Pluto Portal Driver...");
        }

        initDriverConfiguration(servletContext);
        initAdminConfiguration(servletContext);
        initContainer(servletContext);

    }

    /**
     * Recieve notification that the context is being shut down and subsequently
     * destroy the container.
     *
     * @param event the destrubtion event.
     */
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        destroyContainer(servletContext);
        destroyAdminConfiguration(servletContext);
        destroyDriverConfiguration(servletContext);

    }


    /**
     * Initialized the Portal Driver Configuration.
     *
     * @param servletContext
     */
    private void initDriverConfiguration(ServletContext servletContext) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(" * Initializing Portal Driver Configuration...");
        }

        DriverConfiguration config = DriverConfigurationFactory
            .getFactory().getConfig(servletContext);

        if(config == null && LOG.isErrorEnabled()) {
             LOG.error("* Unable to locate Portal Driver Configuration.");
        }
        else if(config != null) {
            servletContext.setAttribute(CONFIG_KEY, config);
            if(LOG.isInfoEnabled()) {
                LOG.info("* Driver Configuration initialized to: "+config.getClass().getName());
            }
        }
    }

    /**
     * Initialize the Admin Configuration if available.
     * @param context
     */
    private void initAdminConfiguration(ServletContext context) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("* Initializing Portal Admin Configuration. . .");
        }

        AdminConfiguration config = DriverConfigurationFactory.getFactory()
                .getAdminConfig(context);

        if(config == null && LOG.isWarnEnabled()) {
            LOG.warn("* Admin Configuration not available.  Administration will not be allowed.");
        }
        else if(config != null) {
            context.setAttribute(ADMIN_KEY, config);
            if(LOG.isInfoEnabled()) {
                LOG.info("* Admin Configuration initialized to: "+config.getClass().getName());
            }
        }
    }

    /**
     * Initialize the Container.
     * @param context
     */
    private void initContainer(ServletContext context) {
        DriverConfiguration config = (DriverConfiguration)
            context.getAttribute(CONFIG_KEY);

        try {
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
                new ContainerServicesImpl(
                        portalContext,
                        config
                );

            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Creating portlet container...");
            }

            PortletContainerFactory factory =
                    PortletContainerFactory.getInstance();

            PortletContainer container = factory.createContainer(
                    config.getContainerName(),
                    containerServices,
                    containerServices
            );

            if (LOG.isDebugEnabled()) {
                LOG.debug(" * Initializing portlet container...");
            }

            container.init(context);
            
            if (LOG.isInfoEnabled()) {
                LOG.info("Pluto Portal Driver started.");
            }
            
            context.setAttribute(CONTAINER_KEY, container);

        } catch (DriverConfigurationException ex) {
            LOG.error("Unable to retrieve driver configuration "
                    + "due to configuration error: " + ex.getMessage(), ex
            );
        } catch (PortletContainerException ex) {
            LOG.error("Unable to start up portlet container: "
                    + ex.getMessage(), ex
            );
        }
    }


    private void destroyContainer(ServletContext servletContext) {
        if (LOG.isInfoEnabled()) {
            LOG.info("Shutting down Pluto Portal Driver...");
        }

        PortletContainer container = (PortletContainer)
                servletContext.getAttribute(CONTAINER_KEY);

        if (container != null) {
            try {
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

    private void destroyDriverConfiguration(ServletContext servletContext) {
        DriverConfiguration config = (DriverConfiguration)
                servletContext.getAttribute(CONFIG_KEY);

        if(config != null) {
            try {
                config.destroy();
                if(LOG.isInfoEnabled()) {
                    LOG.info("Pluto Portal Driver Config shutdown.");
                }
            }
            catch(DriverConfigurationException dce) {

            }
            finally {
                servletContext.removeAttribute(CONFIG_KEY);
            }
        }
    }
    private void destroyAdminConfiguration(ServletContext servletContext) {
        AdminConfiguration config = (AdminConfiguration)
                servletContext.getAttribute(ADMIN_KEY);

        if(config != null) {
            try {
                config.destroy();
                if(LOG.isInfoEnabled()) {
                    LOG.info("Pluto Portal Admin Config shutdown.");
                }
            }
            catch(DriverConfigurationException dce) {

            }
            finally {
                servletContext.removeAttribute(ADMIN_KEY);
            }
        }
    }
}

