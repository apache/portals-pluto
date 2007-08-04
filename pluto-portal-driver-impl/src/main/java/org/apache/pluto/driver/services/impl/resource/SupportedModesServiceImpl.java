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

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletMode;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.container.FilterManagerImpl;
import org.apache.pluto.driver.services.portal.PortletApplicationConfig;
import org.apache.pluto.driver.services.portal.PortletRegistryService;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.SupportedModesService;

/**
 * Allows clients to determine if a particular PortletMode is supported
 * by the portal, a particular portlet, or both.
 * 
 * This implementation depends on {@link PropertyConfigService},  
 * {@link PortletRegistryService}, and {@link PortletContainer}.  
 * The two services are injected by Spring, and the container is obtained
 * from the <code>ServletContext</code>. 
 * 
 * @author <a href="mailto:esm@apache.org">Elliot Metsger</a>
 * @version $Id: SupportedModesServiceImpl.java 545132 2007-06-07 09:59:35Z ukuester $
 * @since September 9, 2006
 * @todo How will hot-deploy of portlets via the admin portlet work with this impl?
 */
public class SupportedModesServiceImpl implements SupportedModesService 
{
    /** Logger */
    private static final Log LOG = LogFactory.getLog(SupportedModesServiceImpl.class);

    /** PortletApplicationConfig objects keyed by their String context path */
    private Map portletApps = new HashMap();
    
    /** Sets containing PortletMode objects keyed by String portlet Id */
    private Map supportedPortletModesByPortlet = new HashMap();
    
    /** PortletMode objects supported by the portal */
    private Set supportedPortletModesByPortal = new HashSet();        
    
    /** PortletContainer used to obtain Portlet Descriptors (PortletAppDD) */
    private PortletContainer container = null;
    
    /** PortletRegistryService used to obtain PortletApplicationConfig objects */
    private PortletRegistryService portletRegistry = null;
    
    /** PropertyConfig Service used to obtain supported portal modes */
    private PropertyConfigService propertySvc = null;
    
    
    /**
     * Constructs a SupportedModesService with its dependencies.
     * 
     * @param portletRegistry the PortletRegistryService
     * @param propertySvc the PropertyConfigService
     */
    public SupportedModesServiceImpl(PortletRegistryService portletRegistry, PropertyConfigService propertySvc)
    {
        this.portletRegistry = portletRegistry;
        this.propertySvc = propertySvc;        
    }
    
    //  SupportedModesService Implementation -----------------
    
    public boolean isPortletModeSupported(String portletId, String mode) 
    {
//        return isPortletModeSupportedByPortal(mode) && isPortletModeSupportedByPortlet(portletId, mode);
    	//For JSR-286
        return isPortletModeSupportedByPortal(mode) || isPortletModeSupportedByPortlet(portletId, mode);
    }

    public boolean isPortletModeSupportedByPortal(String mode) 
    {
        LOG.debug("Is mode [" + mode + "] supported by the portal?");
        return supportedPortletModesByPortal.contains(new PortletMode(mode));
    }

    public boolean isPortletModeSupportedByPortlet(String portletId, String mode) 
    {
        LOG.debug("Is mode [" + mode + "] for portlet [" + portletId + "] supported by the portlet?");
        Set supportedModes = (Set)supportedPortletModesByPortlet.get(portletId);
        if (supportedModes == null)
        {
            return false;
        }        
        return supportedModes.contains(new PortletMode(mode));
    }

    // DriverConfiguration Lifecycle Implementation ---------
    
    public void destroy() throws DriverConfigurationException 
    {
        LOG.debug("Destroying Supported Modes Service...");
        supportedPortletModesByPortlet = null;
        supportedPortletModesByPortal = null;
        container = null;
        portletRegistry = null;
        portletApps = null;        
        propertySvc = null;
        FilterManagerImpl.removeAllFilterApps();
        LOG.debug("Supported Modes Service destroyed.");
    }

    public void init(ServletContext ctx) throws DriverConfigurationException 
    {
        LOG.debug("Initializing Supported Modes Service...");
        // Obtain the Portlet Container
        this.container = (PortletContainer)ctx.getAttribute(AttributeKeys.PORTLET_CONTAINER);
        initInternal();
        LOG.debug("Supported Modes Service initalized.");
    }
    
    // Private Methods --------------------------------------
    
    /**
     * Initialize the data structures for supportedPortletModesByPortal,
     * supportedPortletModesByPortlet, and portletApps.
     * 
     * Note that the order of initalization matters.
     */
    private void initInternal() 
    {
        // portlet applications should be loaded first
        loadPortletApplications();
        loadPortalModes();
        loadPortletModes();        
    }    
    
    /** 
     * Populates the portletApps map with PortletApplicationConfig objects
     * keyed by their context path.
     */
    private void loadPortletApplications() 
    {
        LOG.debug("Loading Portlet Applications...");
        Iterator apps = portletRegistry.getPortletApplications().iterator();
        while (apps.hasNext())
        {
            PortletApplicationConfig app = (PortletApplicationConfig)apps.next();
            LOG.debug("Loading [" + app.getContextPath() + "]");
            portletApps.put(app.getContextPath(), app);
        }
        LOG.debug("Loaded [" + portletApps.size() + "] Portlet Applications.");
    }
    
    /** Populates the supportedPortletModesByPortal set. */
    private void loadPortalModes() 
    {
        // Add the PortletModes supported by the portal to the
        // supportedPortletModesByPortal set.
        LOG.debug("Loading supported portal modes...");        
        Iterator modes = propertySvc.getSupportedPortletModes().iterator();
        while (modes.hasNext()) {
            String mode = (String) modes.next();
            LOG.debug("Loading mode [" + mode + "]");
            supportedPortletModesByPortal.add(new PortletMode(mode));
        }
        LOG.debug("Loaded [" + supportedPortletModesByPortal.size() + "] supported portal modes");
    }
    
    /** 
     * Populates the supportedPortletModesByPortlet map, which contains
     * Sets of PortletMode objects keyed by String portlet Ids.
     */
    private void loadPortletModes()
    {                
        // Add the PortletModes supported by each portlet to
        // the supportedPortletModesByPortlet map.
        LOG.debug("Loading modes supported by each Portlet...");
        Iterator apps = portletApps.values().iterator();
        while (apps.hasNext())
        {
            PortletApplicationConfig app = (PortletApplicationConfig)apps.next();            
            PortletAppDD portletAppDD;
            try {
                portletAppDD = container
                    .getPortletApplicationDescriptor(app.getContextPath());
            } catch (PortletContainerException e) {
                LOG.warn(e);
                continue;
            }
            //init the portletapplication filter
            FilterManagerImpl.addFilterApp(portletAppDD, app.getContextPath());
            // for each portletAppDD, retrieve the portletDD and the supported modes
            Iterator portlets = portletAppDD.getPortlets().iterator();
            while (portlets.hasNext()) {                
                PortletDD portlet = (PortletDD)portlets.next();
                LOG.debug("Loading modes supported by portlet [" + app.getContextPath() + "]." +
                        "[" + portlet.getPortletName() + "]");
                Iterator supports = portlet.getSupports().iterator();
                Set pModes = new HashSet();
                while (supports.hasNext())
                {
                    SupportsDD supportsDD = (SupportsDD)supports.next();
                    if (supportsDD.getPortletModes()!=null){
                    	Iterator portletModes = supportsDD.getPortletModes().iterator();
                    
	                    while (portletModes.hasNext())
	                    {
	                        PortletMode pMode = new PortletMode((String)portletModes.next());
	                        LOG.debug("Adding mode [" + pMode + "]");
	                        pModes.add(pMode);                                
	                    }
                    }
                }
                
                supportedPortletModesByPortlet.put(
                        PortletWindowConfig.createPortletId(app.getContextPath(), portlet.getPortletName()), 
                        pModes);                     
            } 
        }
    }
    
    /**
     * Retrieve the PortletApplicationConfig by its context path.
     * 
     * @param contextPath the context
     * @return the PortletApplicationConfig, or null if it wasn't found.
     */
    private PortletApplicationConfig getPortletApplication(String contextPath) 
    {
        PortletApplicationConfig app = null;
        // attempt to retrieve the PortletApplicationConfig from the map
        app = (PortletApplicationConfig)portletApps.get(contextPath);
        
        // if it wasn't in the map, perhaps it has been added since 
        // the container was started
        if (app == null)
        {
            loadPortletApplications();
        }        
        app = (PortletApplicationConfig)portletApps.get(contextPath);
        return app;
    }    

}
