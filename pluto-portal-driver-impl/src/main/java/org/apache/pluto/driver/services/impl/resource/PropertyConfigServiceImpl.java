/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.*;

import javax.servlet.ServletContext;

import java.util.Iterator;
import java.util.Set;
import java.io.InputStream;

/**
 * Default implementation of all of the portal Services.
 * Utilizes resource configuration from
 * <code>pluto-portal-driver-config.xml</code>
 *
 * @since Aug 10, 2005
 */
public class PropertyConfigServiceImpl implements
    PropertyConfigService {

    private static final Log LOG =
        LogFactory.getLog(PropertyConfigServiceImpl.class);

    private ResourceConfig config;

    public PropertyConfigServiceImpl() {
        
    }

    /**
     * Initialization Lifecycle Method
     * @param ctx
     */
    @SuppressWarnings("unchecked")
    public void init(ServletContext ctx) {
    	
        try {
            InputStream in = ctx.getResourceAsStream(ResourceConfigReader.CONFIG_FILE);
            if (in != null) {
            	config = ResourceConfigReader.getFactory().parse(in);
            } else {
            	Set<String> resourcePaths = ctx.getResourcePaths("/"); // This should be servlet path
            	String msg = "Cannot find resource path for context [" + ctx.getServletContextName() + "] " +
    			" due to problems reading configuration file (pluto-portal-driver-config.xml).";
            	LOG.error(msg);
            	// Show current resource paths...
            	LOG.error("Current resource paths:");
                for (Iterator<String> iterator = resourcePaths.iterator(); iterator.hasNext();) 
                { 
                    String definiton = iterator.next();
                    LOG.error(definiton);
                }
                throw new IllegalStateException(msg);
            }
        } catch (IllegalStateException e) {
        	throw e;//already logged above
        } catch(Exception e) {
        	String msg = "Unable to parse resource config [" + ResourceConfigReader.CONFIG_FILE + "]: " +
        			e.getMessage();
            LOG.error(msg, e);
            throw new DriverConfigurationException(msg, e);
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

//    public Set getPortletApplications() {
//        return config.getPortletApplications();
//    }
}
