/*
 * Copyright 2003,2004 The Apache Software Foundation.
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
/* 

 */

package org.apache.pluto.driver.core;

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.url.PortalURL;
import org.apache.pluto.driver.util.ObjectIdImpl;
import org.apache.pluto.om.ObjectID;

/**
 * Implementation of <code>javax.portlet.PortletWindow</code> interface.
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortletWindowImpl implements PortletWindow {
	
	// Private Member Variables ------------------------------------------------
	
    private PortletWindowConfig config = null;
    private PortalURL portalURL = null;
    private ObjectIdImpl objectIdImpl = null;
    
    
    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param config  the portlet window configuration.
     * @param portalURL  the portal URL.
     */
    public PortletWindowImpl(PortletWindowConfig config, PortalURL portalURL) {
        this.config = config;
        this.portalURL = portalURL;
    }
    
    
    // PortletWindow Impl ------------------------------------------------------
    
    public String getContextPath() {
        return config.getContextPath();
    }

    public String getPortletName() {
        return config.getPortletName();
    }

    public WindowState getWindowState() {
        return portalURL.getWindowState(getId().toString());
    }

    public PortletMode getPortletMode() {
        return portalURL.getPortletMode(getId().toString());
    }

    public ObjectID getId() {
        if (objectIdImpl == null) {
            objectIdImpl = ObjectIdImpl.createFromString(config.getId());
        }
        return objectIdImpl;
    }
}