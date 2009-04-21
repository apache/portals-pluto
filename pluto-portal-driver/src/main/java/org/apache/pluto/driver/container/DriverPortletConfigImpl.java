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
package org.apache.pluto.driver.container;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.portlet.PortletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.pluto.container.driver.DriverPortletConfig;
import org.apache.pluto.container.impl.AbstractPortletConfigImpl;
import org.apache.pluto.container.om.portlet.PortletDefinition;

public class DriverPortletConfigImpl extends AbstractPortletConfigImpl implements DriverPortletConfig {

    private static final Logger LOG = LoggerFactory.getLogger(DriverPortletConfigImpl.class);

    protected ResourceBundleFactory bundles;
    
    public DriverPortletConfigImpl(PortletContext portletContext,
                             PortletDefinition portletDD) {
        super(portletContext, portletDD);
    }

    public ResourceBundle getResourceBundle(Locale locale) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Resource Bundle requested: "+locale);
        }
        if (bundles == null) {
            bundles = new ResourceBundleFactory(portlet, portlet.getPortletInfo());
        }
        return bundles.getResourceBundle(locale);
    }
}
