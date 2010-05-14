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

import org.apache.pluto.container.PortletContainerException;
import org.apache.pluto.container.driver.PortletRegistryService;
import org.apache.pluto.container.om.portlet.CustomWindowState;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.apache.pluto.driver.config.DriverConfigurationException;
import org.apache.pluto.driver.services.portal.PortletWindowConfig;
import org.apache.pluto.driver.services.portal.PropertyConfigService;
import org.apache.pluto.driver.services.portal.SupportedWindowStateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.portlet.WindowState;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SupportedWindowStateServiceImpl implements
        SupportedWindowStateService
{

    /**
     * Logger *
     */
    private static final Logger LOG = LoggerFactory.getLogger(SupportedWindowStateServiceImpl.class);

    /**
     * PropertyConfigService is injected by Spring.  We
     * use it to obtain the window states that the portal
     * supports.  It is protected only so that the unit
     * tests have access to the field.
     */
    protected final PropertyConfigService propertyService;

    /**
     * PortletRegistry is obtained from the PortletContainer on
     * this service's initialization.  It is protected only
     * so that the unit tests have access to the field.
     * <p/>
     * Note that it is an optional container service, but
     * this implmentation requires it.
     */
    protected final PortletRegistryService portletRegistry;

    /**
     * Contains String objects of window states supported
     * by the portal (obtained from PropertyConfigService).
     * It is protected only so that the unit tests have
     * access to the field.
     */
    protected Set portalSupportedWindowStates = new HashSet(3);

    /**
     * Window States that are specified in PLT.9
     */
    protected static final Set JSR168_WINDOW_STATES;

    static
    {
        JSR168_WINDOW_STATES = new HashSet(3);
        JSR168_WINDOW_STATES.add(WindowState.MAXIMIZED);
        JSR168_WINDOW_STATES.add(WindowState.MINIMIZED);
        JSR168_WINDOW_STATES.add(WindowState.NORMAL);
    }

    public SupportedWindowStateServiceImpl(PropertyConfigService propertyService, PortletRegistryService portletRegistry)
    {
        this.propertyService = propertyService;
        this.portletRegistry = portletRegistry;
        LOG.debug("Initializing SupportedWindowStateService... ");

        portalSupportedWindowStates = propertyService.getSupportedWindowStates();
        if (LOG.isDebugEnabled())
        {
            StringBuffer msg = new StringBuffer();

            if (portalSupportedWindowStates != null)
            {
                msg.append("Portal supports [" + portalSupportedWindowStates.size() + "] window states.  ");
                for (Iterator i = portalSupportedWindowStates.iterator(); i.hasNext();)
                {
                    msg.append("[" + i.next() + "]");
                    if (i.hasNext())
                    {
                        msg.append(", ");
                    }
                }
                LOG.debug(msg.toString());
            }
        }

        if (portalSupportedWindowStates == null)
        {
            final String msg = "Portal supported window states is null!";
            LOG.error(msg);
            throw new DriverConfigurationException(msg);
        }
        LOG.debug("SupportedWindowStateService initialized.");
    }

    public boolean isWindowStateSupported(String portletId, String state)
    {
        // If the supplied window state is a JSR 168 window state,
        // we can return immediately
        if (JSR168_WINDOW_STATES.contains(state))
        {
            return true;
        }

        // Otherwise we need to check for custom window states

        return isWindowStateSupportedByPortal(state) &&
                isWindowStateSupportedByPortlet(portletId, state);
    }

    public boolean isWindowStateSupportedByPortal(String state)
    {
        return portalSupportedWindowStates.contains(state);
    }

    public boolean isWindowStateSupportedByPortlet(String portletId, String state)
    {
        if (portletId == null ||
                state == null ||
                portletId.trim().equals("") ||
                state.trim().equals(""))
        {
            StringBuffer errMsg = new StringBuffer("Cannot determine supported window " +
                    "states for portletId [" + portletId + "] and window state [" + state + "].  ");
            String msg = errMsg.append("One or both of the arguments is empty or null.").toString();
            LOG.error(msg);
            throw new IllegalArgumentException(msg);
        }

        // We can short-circut the registry lookup if the window state is
        // one from PLT.9
        if (JSR168_WINDOW_STATES.contains(new WindowState(state)))
        {
            return true;
        }

        // If the supplied window state isn't a JSR 168 window state,
        // we look to see if it is a custom window state.

        String appId = PortletWindowConfig.parseContextPath(portletId);
        String applicationName = appId;
        PortletApplicationDefinition portletAppDD = null;

        if (portletRegistry == null)
        {
            return false;
        }

        try
        {
            portletAppDD = portletRegistry.getPortletApplication(applicationName);
        }
        catch (PortletContainerException e)
        {
            StringBuffer errMsg = new StringBuffer("Cannot determine supported window " +
                    "states for portletId [" + portletId + "] and window state [" + state + "].  ");
            String msg = errMsg.append("Unable to access the Portlet Registry Service.").toString();
            LOG.error(msg, e);
        }

        List customWindowStates = portletAppDD.getCustomWindowStates();
        if (customWindowStates != null)
        {
            for (Iterator i = customWindowStates.iterator(); i.hasNext();)
            {
                CustomWindowState customState = (CustomWindowState) i.next();
                if (customState.getWindowState().equals(state))
                {
                    return true;
                }
            }
        }

        return false;
    }

}
