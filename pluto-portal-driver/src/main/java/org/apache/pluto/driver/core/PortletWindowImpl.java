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
package org.apache.pluto.driver.core;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletEntity;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.PortletWindowID;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.internal.impl.PortletEntityImpl;

/**
 * Implementation of <code>PortletWindow</code> interface.
 */
public class PortletWindowImpl implements PortletWindow {

    /** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletWindowImpl.class);
    
    // Private Member Variables ------------------------------------------------

    private PortletWindowConfig config;
    private PortalURL portalURL;
    private PortletWindowIDImpl objectIdImpl;
    private PortletEntity entity;


    // Constructor -------------------------------------------------------------

    /**
     * Constructs an instance.
     * @param config  the portlet window configuration.
     * @param portalURL  the portal URL.
     */
    public PortletWindowImpl(PortletContainer container, PortletWindowConfig config, PortalURL portalURL) {
        this.config = config;
        this.portalURL = portalURL;
        try
        {
            this.entity = new PortletEntityImpl(container.getOptionalContainerServices().getPortletRegistryService().getPortlet(config.getContextPath(), config.getPortletName()));
        }
        catch (PortletContainerException ex)
        {
            String message = "Unable to load Portlet App Deployment Descriptor:"+ ex.getMessage();
            LOG.error(message, ex);
            throw new RuntimeException(message);
        }
    }


    // PortletWindow Impl ------------------------------------------------------

    public String getContextPath() {
        return config.getContextPath();
    }

    public String getPortletName() {
        return config.getPortletName();
    }

    public WindowState getWindowState() {
        return portalURL.getWindowState(getId().getStringId());
    }

    public PortletMode getPortletMode() {
        return portalURL.getPortletMode(getId().getStringId());
    }

    public PortletWindowID getId() {
        if (objectIdImpl == null) {
            objectIdImpl = PortletWindowIDImpl.createFromString(config.getId());
        }
        return objectIdImpl;
    }

    public PortletEntity getPortletEntity() {
        return entity;
    }
}