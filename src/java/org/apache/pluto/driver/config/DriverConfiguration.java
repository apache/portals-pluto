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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Encapsulation of Configuration Info
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 23, 2004
 */
public class DriverConfiguration {
    private static final Log LOG =
        LogFactory.getLog(DriverConfiguration.class);

    private String portalName;
    private String portalVersion;
    private String containerName;

    private Collection supportedPortletModes;
    private Collection supportedWindowStates;

    private Map portletApplications;
    private RenderConfig renderConfig;

    public DriverConfiguration() {
        this.supportedWindowStates = new ArrayList();
        this.supportedPortletModes = new ArrayList();
        this.portletApplications = new java.util.HashMap();
    }

    public String getPortalName() {
        return portalName;
    }

    public void setPortalName(String portalName) {
        this.portalName = portalName;
    }

    public String getPortalVersion() {
        return portalVersion;
    }

    public void setPortalVersion(String portalVersion) {
        this.portalVersion = portalVersion;
    }

    public String getContainerName() {
        return containerName;
    }

    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    public Collection getSupportedPortletModes() {
        return supportedPortletModes;
    }

    public void setSupportedPortletModes(Collection supportedPortletModes) {
        this.supportedPortletModes = supportedPortletModes;
    }

    public void addSupportedPortletMode(String mode) {
        supportedPortletModes.add(mode);
    }

    public Collection getSupportedWindowStates() {
        return supportedWindowStates;
    }

    public void setSupportedWindowStates(Collection supportedWindowStates) {
        this.supportedWindowStates = supportedWindowStates;
    }

    public void addSupportedWindowState(String state) {
        this.supportedWindowStates.add(state);
    }

    public Collection getPortletApplications() {
        return portletApplications.values();
    }

    public void addPortletApp(PortletApplicationConfig app) {
        if (LOG.isDebugEnabled()) {
            LOG.debug(
                " - - Adding PortletApp Configuration for: " +
                app.getContextPath());
        }
        portletApplications.put(app.getContextPath(), app);
    }

    public PortletApplicationConfig getPortletApp(String id) {
        return (PortletApplicationConfig) portletApplications.get(id);
    }

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

    public RenderConfig getRenderConfig() {
        return renderConfig;
    }

    public void setRenderConfig(RenderConfig renderConfig) {
        this.renderConfig = renderConfig;
    }

    private String getContextFromPortletId(String portletId) {
        int idx = portletId.indexOf(".");
        if (idx < 0) {
            return null;
        }
        return portletId.substring(0, idx);
    }

    private String getPortletNameFromPortletId(String portletId) {
        int idx = portletId.indexOf(".");
        if (idx < 0) {
            return null;
        }
        return portletId.substring(idx + 1);
    }
}

