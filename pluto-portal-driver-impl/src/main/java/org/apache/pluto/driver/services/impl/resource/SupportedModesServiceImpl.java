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
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.SupportedModesService;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.om.portlet.Supports;
import org.apache.pluto.spi.optional.PortletRegistryService;

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
    private static final Log LOG = LogFactory.getLog(SupportedModesServiceImpl.class);

    /** Sets containing PortletMode objects keyed by String portlet Id */
    private Map supportedPortletModesByPortlet = new HashMap();
    
    /** PortletMode objects supported by the portal */
    private Set supportedPortletModesByPortal = new HashSet();

    /** PortletRegistryService used to obtain PortletApplicationConfig objects */
    private PortletRegistryService portletRegistry;

    /** PropertyConfig Service used to obtain supported portal modes */
    private PropertyConfigService propertyService;

    /** The portal's servletContext **/
    private ServletContext servletContext;

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
        return isPortletManagedMode(portletId, mode) || (isPortletModeSupportedByPortal(mode) &&
            isPortletModeSupportedByPortlet(portletId, mode));
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
            portletRegistry = ((PortletContainer)servletContext
                    .getAttribute(AttributeKeys.PORTLET_CONTAINER))
                    .getOptionalContainerServices()
                    .getPortletRegistryService();
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
		//FIXME: This needs to be implemented properly:
		// 1. Need to create a Map of custom modes (CustomModeDD) keyed by portlet ID in init().
		//		a. Each mode has a 'portal-managed' property (true is default)
		// 2. Add code to this method like this:
//		PortletMode oMode = null;		
//		CustomModeDD cmode = null;		
//		if (mode != null) {
//			oMode = new PortletMode(mode);		
//		}
//		cmode = customModes.get(portletId);		
//		if (portletId != null && mode != null && cmode != null 
//			&& supportedPortletModesByPortlet.get(portletId).equals(oMode)
//			&& cmode.getPortletMode().equals(mode) && !cmode.isPortalManaged()) {
//			return true;
//		} else {
//			return false;
//		}
			return false;
	}


}
