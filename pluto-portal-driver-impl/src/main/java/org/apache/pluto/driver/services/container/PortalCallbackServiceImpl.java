/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package org.apache.pluto.driver.services.container;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.AttributeKeys;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.spi.EventProvider;
import org.apache.pluto.spi.FilterManager;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.spi.PortletURLListener;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.spi.PropertyManager;
import org.apache.pluto.spi.ResourceURLProvider;

/**
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalCallbackServiceImpl implements PortalCallbackService 
{
	PropertyManager propertyManager;	

	public PortalCallbackServiceImpl(PropertyManager propertyManager) 
    {
        this.propertyManager = propertyManager;
    }
	
    /**
     * Method invoked by the container when the portlet sets its title. This
     * method binds the dynamic portlet title to the servlet request for later
     * use.
     */
    public void setTitle(HttpServletRequest request,
                         PortletWindow portletWindow,
                         String title) {
        request.setAttribute(AttributeKeys.PORTLET_TITLE, title);
    }

    public PortletURLProvider getPortletURLProvider(
    		HttpServletRequest request,
    		PortletWindow portletWindow) {
        return new PortletURLProviderImpl(request, portletWindow);
    }

    public ResourceURLProvider getResourceURLProvider(
    		HttpServletRequest request,
    		PortletWindow portletWindow) {
        return new ResourceURLProviderImpl(request, portletWindow);
    }

    public PropertyManager getPropertyManager()
    {
        return propertyManager;
    }
    
    public EventProvider getEventProvider(
			HttpServletRequest request, PortletWindow portletWindow) {
		return EventProviderImpl.getEventProviderImpl(request, portletWindow);
	}


	public EventProvider getEventProvider() {
		return EventProviderImpl.getEventProviderImpl();
	}


	/**
     * Returns the FilterManager, this is used to process the filter.
     * @return FilterManager
     */
	public FilterManager getFilterManager(PortletApplicationDefinition portletAppDD, String portletName, String lifeCycle) {
		return FilterManagerImpl.getFilterManager(portletAppDD,portletName,lifeCycle);
	}


	public PortletURLListener getPortletURLListener() {
		return PortletURLListenerImpl.getPortletURLListener();
	}
}

