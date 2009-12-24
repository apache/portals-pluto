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
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.driver.services.portal.RenderConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;

/**
 * Encapsulation of the Pluto Driver ResourceConfig Info.
 *
 * @version 1.0
 * @since Sep 23, 2004
 */
public class ResourceConfig implements PropertyConfigService
{

    /** Internal Logger. */
    private static final Logger LOG =
        LoggerFactory.getLogger(ResourceConfig.class);

    /** The name of the portal. */
    private String portalName;

    /** The Version of the Portal. */
    private String portalVersion;

    /** The name of the container wrapped by this portal. */
    private String containerName;

    /** The portlet modes we will support. */
    private final Set<String> supportedPortletModes = new HashSet<String>();

    /** The window states we will support. */
    private final Set<String> supportedWindowStates = new HashSet<String>();

    /** The portlet applications registered with us. */
//    private final Map portletApplications;

    /** Encapsulation of render configuration data. */
    private RenderConfig renderConfig;

    /**
     * Standard Getter.
     * @return the name of the portal.
     */
    public String getPortalName() {
        return portalName;
    }

    /**
     * Standard Getter.
     * @param portalName the name of the portal.
     */
    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    /**
     * Standard Getter.
     * @return the portal version.
     */
    public String getPortalVersion() {
        return portalVersion;
    }

    /**
     * Standard Setter.
     * @param portalVersion the portal version.
     */
    public void setPortalVersion(String portalVersion) {
        this.portalVersion = portalVersion;
    }

    /**
     * Standard Getter.
     * @return the name of the container.
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * Standard Setter.
     * @param containerName the name of the container.
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * Standard Getter.
     * @return the names of the supported portlet modes.
     */
    public Set<String> getSupportedPortletModes() {
        return supportedPortletModes;
    }

    /**
     * Standard Setter.
     * @param supportedPortletModes the names of the supported portlet modes.
     */
    public void setSupportedPortletModes(Set<String> supportedPortletModes) {
        this.supportedPortletModes.clear();
        this.supportedPortletModes.addAll(supportedPortletModes);
    }

    /**
     * Add the named supported portlet mode to the list of supported modes.
     * @param mode a supported mode.
     */
    public void addSupportedPortletMode(String mode) {
        supportedPortletModes.add(mode);
    }

    /**
     * Standard Getter.
     * @return the names of the supported window states.
     */
    public Set<String> getSupportedWindowStates() {
        return supportedWindowStates;
    }

    /**
     * Standard Setter.
     * @param supportedWindowStates the names of the supported window states.
     */
    public void setSupportedWindowStates(Set<String> supportedWindowStates) {
        this.supportedWindowStates.clear();
        this.supportedWindowStates.addAll(supportedWindowStates);
    }

    /**
     * Add the named supported window state to the list of supported states.
     * @param state the name of the supported state.
     */
    public void addSupportedWindowState(String state) {
        this.supportedWindowStates.add(state);
    }

    /**
     * Standard Getter.
     * @return the render configuration.
     */
    public RenderConfig getRenderConfig() {
        return renderConfig;
    }

    /**
     * Standard Setter.
     * @param renderConfig the render configuration.
     */
    public void setRenderConfig(RenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }

}

