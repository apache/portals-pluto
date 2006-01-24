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
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.io.InputStreamResource;

import javax.servlet.ServletContext;
import java.io.InputStream;

/**
 * 
 * @see DriverConfiguration
 * @see AdminConfiguration
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfigurationFactory {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(
    		DriverConfigurationFactory.class);
    
    /** Portal driver services configuration file name. */
    private static final String DRIVER_CONFIG_FILE =
        	"/WEB-INF/pluto-portal-driver-services-config.xml";
    
    /** The singleton factory instance. */
    private static final DriverConfigurationFactory factory =
    		new DriverConfigurationFactory();
    
    
    // Private Member Variables ------------------------------------------------
    
    private XmlBeanFactory beanFactory = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Private constructor that prevents external instantiation.
     */
    private DriverConfigurationFactory() {
    	// Do nothing.
    }
    
    /**
     * Returns the singleton factory instance.
     * @return the singleton factory instance.
     */
    public static DriverConfigurationFactory getFactory() {
        return factory;
    }
    
    
    // Public Methods ----------------------------------------------------------
    
    public DriverConfiguration getConfig(ServletContext servletContext) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Retrieving driver config from: " + DRIVER_CONFIG_FILE);
        }
        try {
            DriverConfiguration driverConfig = (DriverConfiguration)
                    getBeanFactory(servletContext).getBean(
                    		"DriverConfiguration");
            driverConfig.init(servletContext);
            if(LOG.isDebugEnabled()) {
                LOG.debug("Driver config of type " + driverConfig.getClass()
                		+ " Initialized and Ready For Service.");
            }
            return driverConfig;
        } catch(NoSuchBeanDefinitionException ex) {
            throw new DriverConfigurationException(
            		"Unable to find Driver Configuration.", ex);
        }
    }
    
    
    public AdminConfiguration getAdminConfig(ServletContext servletContext) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Retrieving admin config from: " + DRIVER_CONFIG_FILE);
        }
        try {
            AdminConfiguration adminConfig = (AdminConfiguration)
                    getBeanFactory(servletContext).getBean(
                    		"AdminConfiguration");
            adminConfig.init(servletContext);
            if(LOG.isDebugEnabled()) {
                LOG.debug("Admin config of type " + adminConfig.getClass()
                		+ "Initialized and ready for service.");
            }
            return adminConfig;
        } catch (NoSuchBeanDefinitionException ex) {
            return null;
        }
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    private XmlBeanFactory getBeanFactory(ServletContext servletContext) {
        if (beanFactory == null) {
            InputStream is = servletContext.getResourceAsStream(
            		DRIVER_CONFIG_FILE);
            beanFactory = new XmlBeanFactory(new InputStreamResource(
            		is, "Driver Configuration"));
        }
        return beanFactory;
    }

}

