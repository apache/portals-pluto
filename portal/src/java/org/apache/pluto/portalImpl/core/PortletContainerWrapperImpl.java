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

package org.apache.pluto.portalImpl.core;

import java.io.IOException;
import java.util.Properties;

import javax.portlet.PortletException;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.PortletContainerEnvironment;

/**
 * 

 */
public class PortletContainerWrapperImpl implements PortletContainer {

    // PortletContainer implementation.

    public void init(String uniqueContainerName,
                     ServletConfig servletConfig,
                     PortletContainerEnvironment environment,
                     Properties properties)
    throws PortletContainerException
    {
        PortletContainerFactory.
        getPortletContainerOriginal().
        init(uniqueContainerName,
             servletConfig, 
             environment,
             properties);
    }

    public void shutdown() throws PortletContainerException
    {
        PortletContainerFactory.
        getPortletContainerOriginal().
        shutdown();
    }


    public void renderPortlet(PortletWindow portletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse )
    throws PortletException, IOException, PortletContainerException
    {
        PortletContainerFactory.
        getPortletContainerOriginal().
        renderPortlet(portletWindow, 
                      servletRequest, 
                      servletResponse);
    }

    public void processPortletAction(PortletWindow portletWindow,
                                     HttpServletRequest servletRequest,
                                     HttpServletResponse servletResponse )
    throws PortletException, IOException, PortletContainerException
    {
        PortletContainerFactory.
        getPortletContainerOriginal().
        processPortletAction(portletWindow, 
                             servletRequest, 
                             servletResponse);
    }

    public void portletLoad(PortletWindow portletWindow,
                            HttpServletRequest servletRequest,
                            HttpServletResponse servletResponse )
    throws PortletException, PortletContainerException
    {
        PortletContainerFactory.
        getPortletContainerOriginal().
        portletLoad(portletWindow, 
                    servletRequest, 
                    servletResponse);
    }

    public boolean isInitialized() {
        return PortletContainerFactory.getPortletContainerOriginal().isInitialized();
    }

}
