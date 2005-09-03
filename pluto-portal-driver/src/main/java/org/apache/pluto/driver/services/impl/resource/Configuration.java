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
package org.apache.pluto.driver.services.impl.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.*;

/**
 * Encapsulation of the Pluto Driver Configuration Info.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class Configuration {
    /** Internal Logger. */
    private static final Log LOG =
        LogFactory.getLog(Configuration.class);

    /** The name of the portal. */
    private String portalName;

    /** The Version of the Portal. */
    private String portalVersion;

    /** The name of the container wrapped by this portal. */
    private String containerName;

    /** The portlet modes we will support. */
    private Set supportedPortletModes;

    /** The window states we will support. */
    private Set supportedWindowStates;

    /** The portlet applications registered with us. */
    private Map portletApplications;

    /** Encapsulation of render configuration data. */
    private RenderConfig renderConfig;

    /**
     * Default Constructor.
     */
    public Configuration() {
        this.supportedWindowStates = new HashSet();
        this.supportedPortletModes = new HashSet();
        this.portletApplications = new java.util.HashMap();
    }

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
    public Set getSupportedPortletModes() {
        return supportedPortletModes;
    }

    /**
     * Standard Setter.
     * @param supportedPortletModes the names of the supported portlet modes.
     */
    public void setSupportedPortletModes(Set supportedPortletModes) {
        this.supportedPortletModes = supportedPortletModes;
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
    public Set getSupportedWindowStates() {
        return supportedWindowStates;
    }

    /**
     * Standard Setter.
     * @param supportedWindowStates the names of the supported window states.
     */
    public void setSupportedWindowStates(Set supportedWindowStates) {
        this.supportedWindowStates = supportedWindowStates;
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
     * @return the configuration data of all configured portlet applications.
     */
    public Set getPortletApplications() {
        return new HashSet(portletApplications.values());
    }

    /**
     * Add a porltet applicaiton conofiguration to this list of portlet apps.
     * @param app portlet application coniguration data.
     */
    public void addPortletApp(PortletApplicationConfig app) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(
                " - - Adding PortletApp Configuration for: " +
                app.getContextPath());
        }
        portletApplications.put(app.getContextPath(), app);
    }

    /**
     * Retrieve the portlet application with the given id.
     * @param id the id of the portlet application.
     * @return the portlet application configuration data.
     */
    public PortletApplicationConfig getPortletApp(String id) {
        return (PortletApplicationConfig) portletApplications.get(id);
    }

    /**
     * Retrieve the window configuration associated with the given id.
     * @param id the id of the portlet window.
     * @return the portlet window configuration data.
     */
    public PortletWindowConfig getPortletWindowConfig(String id) {
        if (id == null) {
            return null;
        }
        String context = getContextFromPortletId(id);
        String portlet = getPortletNameFromPortletId(id);

        PortletApplicationConfig app = getPortletApp(context);
        if (app == null) {
            if (LOG.isErrorEnabled()) {
                LOG.error("Portlet Application '" + context + "' not found.");
            }
            return null;
        }
        return app.getPortlet(portlet);
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

    /**
     * Retrieve the id of the context from the portlet id.
     * @param portletId the id of the portlet.
     * @return the context, derived from the portlet id.
     */
    private String getContextFromPortletId(String portletId) {
        int idx = portletId.indexOf(".");
        if (idx < 0) {
            return null;
        }
        return portletId.substring(0, idx);
    }

    /**
     *  Retreive the porlet name from the given portletId.
     * @param portletId the portlet id.
     * @return the name of the portlet.
     */
    private String getPortletNameFromPortletId(String portletId) {
        int idx = portletId.indexOf(".");
        if (idx < 0) {
            return null;
        }
        return portletId.substring(idx + 1);
    }
}

