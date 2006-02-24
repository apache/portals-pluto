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
import org.apache.pluto.driver.services.portal.admin.PortletRegistryAdminService;
import org.apache.pluto.driver.services.portal.admin.DriverAdministrationException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.internal.PortletDescriptorRegistry;
import org.apache.pluto.PortletContainerException;

import javax.servlet.ServletContext;
import java.util.Set;
import java.util.Iterator;
import java.io.InputStream;

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
                throw new DriverAdministrationException(
                		"Unable to locate servlet context: " + contextPath
                		+ ": ensure that crossContext support is enabled "
                		+ "and the portlet application has been deployed.");
            }

            PortletAppDD portletAppDD = getPortletDescriptor(
            		portletAppServletContext);
            if (portletAppDD == null) {
            	throw new DriverAdministrationException(
            			"Unable to retrieve portlet application descriptor from "
            			+ contextPath + ": ensure that the portlet application "
            			+ "has been deployed.");
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
            throw new DriverAdministrationException(
            		"Unable to add portlet application from " + contextPath, ex);
        }
    }
    
    /**
     * FIXME: do we really need this public method?
     */
    public PortletWindowConfig getPortletWindowConfig(String id) {
        return config.getPortletWindowConfig(id);
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    private PortletAppDD getPortletDescriptor(ServletContext context)
    throws PortletContainerException {
        return PortletDescriptorRegistry.getRegistry().getPortletAppDD(context);
    }
    
}
