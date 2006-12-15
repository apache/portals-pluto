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

import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.core.PortletContextManager;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.PortletApplicationConfig;
import org.apache.pluto.driver.services.portal.PortletRegistryService;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.admin.DriverAdministrationException;
import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.spi.optional.PortletRegistryEvent;
import org.apache.pluto.spi.optional.PortletRegistryListener;

/**
 * Implementation of <code>PortletRegistryService</code> and
 * <code>PortletRegistryAdminService</code>.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @since Aug 10, 2005
 */
public class PortletRegistryServiceImpl
implements PortletRegistryService, PortletRegistryAdminService {

    private static final Log LOG = LogFactory.getLog(PortletRegistryServiceImpl.class);
    private ResourceConfig config;
    private ServletContext servletContext;
    
         
    // Constructor -------------------------------------------------------------
    
    /**
     * Default no-arg constructor.
     */
    public PortletRegistryServiceImpl() {
        // Do nothing.
    }
    
    
    // DriverConfigurationService Impl -----------------------------------------
    
    /**
     * Initialization Lifecycle Method
     * @param servletContext  the servlet context.
     */
    public void init(ServletContext servletContext)
    throws DriverConfigurationException {
        try {
            this.servletContext = servletContext;
            InputStream in = servletContext.getResourceAsStream(
            		ResourceConfigReader.CONFIG_FILE);
            this.config = ResourceConfigReader.getFactory().parse(in);
        } catch (Exception ex) {
            throw new DriverConfigurationException(ex);
        }
        
        PortletContextManager.getManager().addPortletRegistryListener(
                new PortletRegistryEventListener());
    }

    public void destroy() throws DriverConfigurationException {
        config = null;
        servletContext = null;
    }
    
    
    // PortletRegistryService Impl ---------------------------------------------
    
    public Set getPortletApplications() {
        return config.getPortletApplications();
    }

    public PortletApplicationConfig getPortletApplication(String id) {
        return config.getPortletApp(id);
    }

    public PortletWindowConfig getPortlet(String id) {
        return config.getPortletWindowConfig(id);
    }
    
    
    // PortletRegistryAdminService Impl ----------------------------------------
    
    public void addPortletApplication(String contextPath)
    throws DriverAdministrationException {
        if (contextPath == null) {
            throw new IllegalArgumentException(
            		"Portlet application context path cannot be null.");
        }
        try {
            PortletApplicationConfig portletAppConfig =
            		new PortletApplicationConfig();
            portletAppConfig.setContextPath(contextPath);

            ServletContext portletAppServletContext = servletContext.getContext(contextPath);
            if (portletAppServletContext == null) {
                final String msg = "Unable to locate servlet context: " + contextPath                    
                    + ": ensure that crossContext support is enabled "
                    + "and the portlet application has been deployed.";
                LOG.error(msg);
                throw new DriverAdministrationException(msg);
            }
            
            PortletContainer container = (PortletContainer)servletContext
                .getAttribute(AttributeKeys.PORTLET_CONTAINER);
            
            PortletAppDD portletAppDD = container.getOptionalContainerServices()
                .getPortletRegistryService()
                .getPortletApplicationDescriptor(contextPath);
            
            if (portletAppDD == null) {
                final String msg = "Unable to retrieve portlet application descriptor from "
                    + contextPath + ": ensure that the portlet application "
                    + "has been deployed.";
                LOG.error(msg);
            	throw new DriverAdministrationException(msg);
            }
            for (Iterator it = portletAppDD.getPortlets().iterator();
            		it.hasNext(); ) {
                PortletDD portletDD = (PortletDD) it.next();
                PortletWindowConfig portletWindowConfig = new PortletWindowConfig();
                portletWindowConfig.setContextPath(contextPath);
                portletWindowConfig.setPortletName(portletDD.getPortletName());
                portletAppConfig.addPortlet(portletWindowConfig);
            }
            config.addPortletApp(portletAppConfig);
            
        } catch (PortletContainerException ex) {
            final String msg = "Unable to add portlet application from " + contextPath;
            LOG.error(msg);
            throw new DriverAdministrationException(msg, ex);
        }
    }
    
    /**
     * FIXME: do we really need this public method?
     */
    public PortletWindowConfig getPortletWindowConfig(String id) {
        return config.getPortletWindowConfig(id);
    }
    
    /** 
     * Listens for events fired by the container's PortletRegistry Service
     * and acts accordingly - by adding or removing portlets from
     * the ResourceConfig. 
     * 
     * @todo implement portletApplicationRemoved
     */
    private class PortletRegistryEventListener implements PortletRegistryListener {
        
        public void portletApplicationRegistered(PortletRegistryEvent event) {
            if (isNullOrEmpty(event)) {
                return;                
            }
                
            if (LOG.isDebugEnabled()) {
                LOG.debug( "Portlet Registry service received a portlet registered " +
                        "event [" + event + "]; Adding portlet application [" +
                        event.getApplicationId() + "]");
            }
            
            try {
                addPortletApplication(event.getApplicationId());
            } catch (DriverAdministrationException e) {
                LOG.error( "Unable to add portlet [" + event.getApplicationId() + "] " +
                        "to the Portlet Registry", e);
                // I don't think there is anything we can do to recover from this
                // condition, so do nothing here.
            }            
        }

        public void portletApplicationRemoved(PortletRegistryEvent event) {
            if (isNullOrEmpty(event)) {
                return;
            }
                
            
            if (LOG.isDebugEnabled()) {
                LOG.debug( "Portlet Registry service received a portlet registered " +
                        "event [" + event + "]; Removing portlet application [" +
                        event.getApplicationId() + "]");
            }
            
            // FIXME: fill in body
            LOG.warn("Portlet Application Removed event is currently a noop!");
            
            
        }
        
        private boolean isNullOrEmpty (PortletRegistryEvent e)
        {
            if (e == null || e.getApplicationId() == null)
            {
                LOG.warn( "Unable to act on PortletRegistryEvent event: " +
                        "either the event was null or it did not return an application id.");
                return true;
            }   
            return false;
        }        
    }
            
}
