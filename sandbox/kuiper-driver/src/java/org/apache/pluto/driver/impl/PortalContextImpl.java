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

package org.apache.pluto.driver.impl;

import javax.portlet.PortalContext;
import javax.portlet.WindowState;
import javax.portlet.PortletMode;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Properties;

/**
 *
 * @author <A href="mailto:ddewolf@apache.org">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 9, 2004 at 5:39:28 PM
 */
public class PortalContextImpl implements PortalContext {

    private Vector states;
    private Vector modes;
    private Properties properties;

    public PortalContextImpl(Properties portalProperties) {
        states = new Vector();
        states.add(WindowState.NORMAL);
        states.add(WindowState.MAXIMIZED);
        states.add(WindowState.MINIMIZED);

        modes = new Vector();
        modes.add(PortletMode.VIEW);
        modes.add(PortletMode.EDIT);
        modes.add(PortletMode.HELP);

        this.properties = portalProperties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public Enumeration getPropertyNames() {
        return properties.keys();
    }

    public Enumeration getSupportedPortletModes() {
        return modes.elements();
    }

    public Enumeration getSupportedWindowStates() {
        return states.elements();
    }

    public String getPortalInfo() {
        return "Pluto Kuiper Driver/1.0";
    }

}
