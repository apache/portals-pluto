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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.InternalPortletRequest;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

/**
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates. To enable and disable the creation of type
 * comments go to Window>Preferences>Java>Code Generation.
 */
public class RenderRequestImpl extends PortletRequestImpl
    implements RenderRequest {
    private static final Log LOG = LogFactory.getLog(RenderRequestImpl.class);
    /**
     * Holds the portlet preferences
     */
    private PortletPreferences portletPreferences = null;

    public RenderRequestImpl(InternalPortletRequest request) {
        super(request);    
    }

    public RenderRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             javax.servlet.http.HttpServletRequest servletRequest) {
        super(container, internalPortletWindow, servletRequest);
    }

    // additional methods -------------------------------------------------------------------------
    /**
     * @see javax.servlet.ServletRequest#getReader()
     */
    public BufferedReader getReader() throws IOException {
        return super.getReader();
    }

    public PortletPreferences getPreferences() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Getting Preferences: " + portletPreferences);
        }

        if (portletPreferences == null) {
            portletPreferences = new PortletPreferencesImpl(getContainer(),
                                                            getWindow(), this,
                                                            Constants.METHOD_ACTION);
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Returning Preferences: " + portletPreferences);
            Enumeration e = portletPreferences.getNames();
            while (e.hasMoreElements()) {
                String name = (String) e.nextElement();
                LOG.debug(" - Preference: name = " + name);
            }
        }

        return portletPreferences;
    }
    // --------------------------------------------------------------------------------------------
}
