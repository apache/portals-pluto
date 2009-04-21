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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;
import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.driver.PlutoServices;
import org.apache.pluto.container.driver.PortletContextService;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.container.om.portlet.PortletDefinition;
import org.apache.pluto.container.om.portlet.Supports;
import org.apache.pluto.container.om.portlet.impl.CustomPortletModeType;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.SupportedModesService;

/**
 * Allows clients to determine if a particular PortletMode is supported
 * by the portal, a particular portlet, or both.
 *
 * This implementation depends on {@link PropertyConfigService}.
 *
 * The service implementations are injected by Spring.
 *
 * @version $Id$
 * @since September 9, 2006
 */
public class SupportedModesServiceImpl implements SupportedModesService
{
    /** Logger */
    private static final Logger LOG = LoggerFactory.getLogger(SupportedModesServiceImpl.class);

    
    /** PortletMode objects supported by the portal */
    private Set<PortletMode> supportedPortletModesByPortal = new HashSet<PortletMode>();

    /** PortletRegistryService used to obtain PortletApplicationConfig objects */
    private PortletRegistryService portletRegistry;

    /** PropertyConfig Service used to obtain supported portal modes */
    private PropertyConfigService propertyService;

    /** The portal's servletContext **/
    private ServletContext servletContext;
    
    private PortletContextService portletContextService;

    /**
     * Constructs a SupportedModesService with its dependencies.
     *
     * @param propertyService the PropertyConfigService
     */
    public SupportedModesServiceImpl(PropertyConfigService propertyService) {
        this.propertyService = propertyService;
    }

    //  SupportedModesService Implementation -----------------

    public boolean isPortletModeSupported(String portletId, String mode)  {
        return (isPortletModeSupportedByPortal(mode) &&
            isPortletModeSupportedByPortlet(portletId, mode)
            || isPortletManagedMode(portletId, mode));
    }

    public boolean isPortletModeSupportedByPortal(String mode)  {
        return supportedPortletModesByPortal.contains(new PortletMode(mode));
    }

    public boolean isPortletModeSupportedByPortlet(String portletId, String mode) {
        String applicationId = PortletWindowConfig.parseContextPath(portletId);
        String applicationName = applicationId;
        if (applicationName.length() >0 )
        {
            applicationName = applicationName.substring(1);
        }
        String portletName = PortletWindowConfig.parsePortletName(portletId);
        // since SupportedModesService is consulted per portal portal mode per portlet
        // per render request, store a reference to the registry instead of looking
        // it up each time.  Is this premature optimization?
        if (portletRegistry == null) {
            portletRegistry = PlutoServices.getServices().getPortletRegistryService();
        }

        try {
            if (portletRegistry == null) {
                LOG.error("Optional Portlet Registry Service not found.");
                throw new PortletContainerException("Optional Portlet Registry Service not found.");
            }
            PortletApplicationDefinition ctx = portletRegistry.getPortletApplication(applicationName);
            Iterator i = ctx.getPortlets().iterator();
            while(i.hasNext()) {
                PortletDefinition dd = (PortletDefinition)i.next();
                if(portletName.equals(dd.getPortletName())) {
                    Iterator i2 = dd.getSupports().iterator();
                    while(i2.hasNext()) {
                        Supports sd = (Supports)i2.next();
                        if (sd.getPortletModes()==null){
                        	if (mode.equalsIgnoreCase(PortletMode.VIEW.toString()))
                        		return true;
                        }
                        else{
	                        Iterator pd = sd.getPortletModes().iterator();
	                        while(pd.hasNext()) {
	                            if(mode.equalsIgnoreCase((String)pd.next())) {
	                                return true;
	                            }
	                        }
                        }
                    }
                }
            }

        } catch (PortletContainerException e) {
            LOG.error("Error determining mode support.", e);
        }
        LOG.info("Portlet mode '"+mode+"' not found for portletId: '"+portletId+"'");
        return false;
    }

    // DriverConfiguration Lifecycle Implementation ---------

    public void destroy() throws DriverConfigurationException
    {
        LOG.debug("Destroying Supported Modes Service...");
        supportedPortletModesByPortal = null;
        portletRegistry = null;
        propertyService = null;
        LOG.debug("Supported Modes Service destroyed.");
    }

    public void init(ServletContext ctx) throws DriverConfigurationException {
        this.servletContext = ctx;
        this.portletContextService = PlutoServices.getServices().getPortletContextService();
        loadPortalModes();
    }    
    

    /** Populates the supportedPortletModesByPortal set. */
    private void loadPortalModes()
    {
        // Add the PortletModes supported by the portal to the
        // supportedPortletModesByPortal set.
        LOG.debug("Loading supported portal modes...");
        Iterator modes = propertyService.getSupportedPortletModes().iterator();
        while (modes.hasNext()) {
            String mode = (String) modes.next();
            LOG.debug("Loading mode [" + mode + "]");
            supportedPortletModesByPortal.add(new PortletMode(mode));
        }
        LOG.debug("Loaded [" + supportedPortletModesByPortal.size() + "] supported portal modes");

    }


    
	public boolean isPortletManagedMode(String portletId, String mode) {

		if (portletRegistry == null) {
            portletRegistry = PlutoServices.getServices().getPortletRegistryService();
        }
        //
        
        //
        String applicationId = PortletWindowConfig.parseContextPath(portletId);
        String applicationName = applicationId;
        if (applicationName.length() > 0 )
        {
            applicationName = applicationName.substring(1);
        }
        try {
			PortletApplicationDefinition portletApp = portletRegistry.getPortletApplication(applicationName);
            Iterator customModes = portletApp.getCustomPortletModes().iterator();
            while (customModes.hasNext()) {
				CustomPortletModeType customMode = (CustomPortletModeType)customModes.next();
				boolean isPortletManagedMode = !customMode.isPortalManaged(); 
				if (isPortletManagedMode && customMode.getPortletMode().equalsIgnoreCase(mode)) {
					return true;
				}
			}
		} catch (PortletContainerException e) {
            LOG.error("Error determining portlet managed mode support, so we assume that it is false.", e);
		}

		
		return false;
	}


	/**
	 * Gets all modes supported by a portlet that are defined in the portlet's supports child element 
	 * in portlet.xml.
	 * 
	 * @param portlet of interest.
	 * @return all portlet modes supported by a portlet.
	 */
	public Set<PortletMode> getSupportedPortletModes(String portletId) throws PortletContainerException {
		Set<PortletMode> modeSet = new HashSet<PortletMode>();

	       String applicationId = PortletWindowConfig.parseContextPath(portletId);
	        String applicationName = applicationId;
	        if (applicationName.length() >0 )
	        {
	            applicationName = applicationName.substring(1);
	        }
	        String portletName = PortletWindowConfig.parsePortletName(portletId);
	        // since SupportedModesService is consulted per portal portal mode per portlet
	        // per render request, store a reference to the registry instead of looking
	        // it up each time.  Is this premature optimization?
	        if (portletRegistry == null) {
	            portletRegistry = PlutoServices.getServices().getPortletRegistryService();
	        }

            if (portletRegistry == null) {
                LOG.error("Optional Portlet Registry Service not found.");
                throw new PortletContainerException("Optional Portlet Registry Service not found.");
            }
            PortletApplicationDefinition portletApp = portletRegistry.getPortletApplication(applicationName);
            Iterator i =  portletApp.getPortlets().iterator();
            while(i.hasNext()) {
                PortletDefinition dd = (PortletDefinition)i.next();
                if(portletName.equals(dd.getPortletName())) {
                    Iterator i2 = dd.getSupports().iterator();
                    while(i2.hasNext()) {
                        Supports sd = (Supports)i2.next();
                        if (sd.getPortletModes()== null){
                        	modeSet.add(PortletMode.VIEW);
                        }
                        else{
	                        Iterator<String> pd = sd.getPortletModes().iterator();
	                        while(pd.hasNext()) {
	                        	modeSet.add(new PortletMode(pd.next()));
	                        }
                        }
                    }
                }
            }

		return modeSet;
	}
	
	public PortletConfig getPortletConfig(String portletId) throws PortletContainerException {
	       String applicationId = PortletWindowConfig.parseContextPath(portletId);
	        String applicationName = applicationId;
	        if (applicationName.length() >0 )
	        {
	            applicationName = applicationName.substring(1);
	        }
	        String portletName = PortletWindowConfig.parsePortletName(portletId);
	        if (portletRegistry == null) {
	            portletRegistry = PlutoServices.getServices().getPortletRegistryService();
	        }
	        
		return portletContextService.getPortletConfig(applicationName, portletName);
	}
}
