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

package org.apache.pluto.core;

import javax.portlet.Portlet;
import javax.portlet.PortletConfig;

/**
 *
 * @author <A href="mailto:david.dewolf@vivare.com">David H. DeWolf</A>
 * @version 1.0
 * @since Mar 19, 2004 at 7:34:56 PM
 */
public class RegisteredPortlet {

    private Portlet portlet;
    private PortletConfig config;

    public RegisteredPortlet(Portlet portlet, PortletConfig config) {
        this.portlet = portlet;
        this.config = config;
    }

    public Portlet getPortlet() {
        return portlet;
    }

    public void setPortlet(Portlet portlet) {
        this.portlet = portlet;
    }

    public PortletConfig getConfig() {
        return config;
    }

    public void setConfig(PortletConfig config) {
        this.config = config;
    }
}
