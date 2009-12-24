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
package org.apache.pluto.driver.config.impl;

import java.util.Collection;
import java.util.Set;

import javax.portlet.PortletConfig;
import javax.portlet.PortletMode;

import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.driver.config.DriverConfiguration;
import org.apache.pluto.driver.services.portal.PageConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.RenderConfigService;
import org.apache.pluto.driver.services.portal.SupportedModesService;
import org.apache.pluto.driver.services.portal.SupportedWindowStateService;
import org.apache.pluto.driver.url.PortalURLParser;

/**
 * Encapsulation of the Pluto Driver ResourceConfig.
 *
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfigurationImpl
    implements DriverConfiguration {

    private final PortalURLParser portalUrlParser;
    private final PropertyConfigService propertyService;
    private final RenderConfigService renderService;
    private final SupportedModesService supportedModesService;
    private final SupportedWindowStateService supportedWindowStateService;

    // Container Services
    private PortletPreferencesService portletPreferencesService;
    
    public DriverConfigurationImpl(PortalURLParser portalUrlParser,
                                   PropertyConfigService propertyService,
                                   RenderConfigService renderService,
                                   SupportedModesService supportedModesService,
                                   SupportedWindowStateService supportedWindowStateService) {

        this.portalUrlParser = portalUrlParser;
        this.propertyService = propertyService;
        this.renderService = renderService;
        this.supportedModesService = supportedModesService;
        this.supportedWindowStateService = supportedWindowStateService;
    }

    /**
     * Standard Getter.
     * @return the name of the portal.
     */
    public String getPortalName() {
        return propertyService.getPortalName();
    }

    /**
     * Standard Getter.
     * @return the portal version.
     */
    public String getPortalVersion() {
        return propertyService.getPortalVersion();
    }

    /**
     * Standard Getter.
     * @return the name of the container.
     */
    public String getContainerName() {
        return propertyService.getContainerName();
    }

    /**
     * Standard Getter.
     * @return the names of the supported portlet modes.
     */
    public Collection getSupportedPortletModes() {
        return propertyService.getSupportedPortletModes();
    }

    /**
     * Standard Getter.
     * @return the names of the supported window states.
     */
    public Collection getSupportedWindowStates() {
        return propertyService.getSupportedWindowStates();
    }

    /**
     * Standard Getter.
     * @return the render configuration.
     */
    public Collection getPages() {
        return renderService.getPages();
    }

    public PageConfig getPageConfig(String pageId) {
        return renderService.getPage(pageId);
    }
    
    public boolean isPortletModeSupportedByPortal(String mode) {
        return supportedModesService.isPortletModeSupportedByPortal(mode);
    }
    
    public boolean isPortletModeSupportedByPortlet(String portletId, String mode) {
        return supportedModesService.isPortletModeSupportedByPortlet(portletId, mode);
    }
    
    public boolean isPortletModeSupported(String portletId, String mode) {
        return supportedModesService.isPortletModeSupported(portletId, mode);
    }

//
// Portal Driver Services
//

    public PortalURLParser getPortalUrlParser() {
        return portalUrlParser;
    }

//
// Container Services
//
    public PortletPreferencesService getPortletPreferencesService() {
        return portletPreferencesService;
    }

    public void setPortletPreferencesService(PortletPreferencesService portletPreferencesService) {
        this.portletPreferencesService = portletPreferencesService;
    }

    public boolean isWindowStateSupported(String portletId, String windowState)
    {
        return supportedWindowStateService.isWindowStateSupported(portletId, windowState);
    }

    public boolean isWindowStateSupportedByPortal(String windowState)
    {
        return supportedWindowStateService.isWindowStateSupportedByPortal(windowState);
    }

    public boolean isWindowStateSupportedByPortlet(String portletId, String windowState)
    {
        return supportedWindowStateService.isWindowStateSupportedByPortlet(portletId, windowState);
    }
    
    public RenderConfigService getRenderConfigService(){
    	return renderService;
    }

    public Set<PortletMode> getSupportedPortletModes(String portletId) throws PortletContainerException {
    	return supportedModesService.getSupportedPortletModes(portletId);
    }

	public boolean isPortletManagedMode(String portletId, String mode) {
		return supportedModesService.isPortletManagedMode(portletId, mode);
	}
	
    public PortletConfig getPortletConfig(String portletId)  throws PortletContainerException {
    	return supportedModesService.getPortletConfig(portletId);
    }
}

