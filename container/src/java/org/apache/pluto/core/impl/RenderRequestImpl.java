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

package org.apache.pluto.core.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;

import org.apache.pluto.factory.PortletObjectAccess;
import org.apache.pluto.om.window.PortletWindow;
import org.apache.pluto.services.log.LogService;
import org.apache.pluto.services.log.Logger;
import org.apache.pluto.PortletContainerServices;

/**

 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class RenderRequestImpl extends PortletRequestImpl implements RenderRequest {
    /**
     * Holds the portlet preferences
     */
    private PortletPreferences portletPreferences = null;
    private Logger log = null;

    public RenderRequestImpl(PortletWindow portletWindow,
                             javax.servlet.http.HttpServletRequest servletRequest)
    {
        super(portletWindow, servletRequest);
        this.log = ((LogService)PortletContainerServices
                      .get(LogService.class)).getLogger(getClass());
    }

    // additional methods -------------------------------------------------------------------------
    /**
     * @see javax.servlet.ServletRequest#getReader()
     */
    public BufferedReader getReader() throws IOException
    {
        return super.getReader();
    }

    public PortletPreferences getPreferences()
    {
        if(log.isDebugEnabled()) {
            log.debug("Getting Preferences: "+portletPreferences);
        }

        if (portletPreferences == null) {
            portletPreferences = PortletObjectAccess.getPortletPreferences(
                org.apache.pluto.Constants.METHOD_RENDER,
                super.getInternalPortletWindow().getPortletEntity()
            );
        }
        if(log.isDebugEnabled()) {
            log.debug("Returning Preferences: " + portletPreferences);
            Enumeration e = portletPreferences.getNames();
            while (e.hasMoreElements()) {
                String name = (String)e.nextElement();
                log.debug(" - Preference: name = " + name);
            }
        }

        return portletPreferences; 
    }
    // --------------------------------------------------------------------------------------------
}
