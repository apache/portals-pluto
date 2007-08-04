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
package org.apache.pluto.internal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ResourceBundle;
import java.util.PropertyResourceBundle;

/**
 * Central location for Configuration info.
 *
 * @author ddewolf@apache.org
 * @since Jul 2, 2005
 */
class Configuration {
    
    private static final Log LOG = 
            LogFactory.getLog(Configuration.class);

    public static final ResourceBundle BUNDLE =
        PropertyResourceBundle.getBundle("org.apache.pluto.core.pluto-configuration");

    private static final String DESCRIPTOR_SERVICE =
        "org.apache.pluto.descriptors.services.PortletAppDescriptorService";
            

    public static String getPortletAppDescriptorServiceImpl() {
        String impl =  BUNDLE.getString(DESCRIPTOR_SERVICE);
        if(LOG.isDebugEnabled()) {
            LOG.debug("Using Descriptor Service Impl: "+impl);
        }
        return impl;
    }
}
