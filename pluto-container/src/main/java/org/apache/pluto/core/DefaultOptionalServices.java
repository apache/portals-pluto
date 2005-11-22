/*
 * Copyright 2004 The Apache Software Foundation.
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

import javax.portlet.PortletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.OptionalPortletContainerServices;
import org.apache.pluto.services.optional.PortletPreferencesService;
import org.apache.pluto.services.optional.PortletEnvironmentService;
import org.apache.pluto.services.optional.PortletInvokerService;

/**
 * Default Optional Services implementation.
 *
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 18, 2004
 */
public class DefaultOptionalServices implements OptionalPortletContainerServices {

    private static final Log LOG =
        LogFactory.getLog(DefaultOptionalServices.class);

    private PortletPreferencesService preferenceService;

    public DefaultOptionalServices() {
        this.preferenceService = new PortletPreferencesServiceImpl();
    }


    public PortletPreferencesService getPortletPreferencesService() {
        return preferenceService;
    }

    public class PortletPreferencesServiceImpl
        implements PortletPreferencesService {

        public PortletPreference[] getStoredPreferences(PortletWindow window,
                                                        PortletRequest req)
        throws PortletContainerException {
            return new PortletPreference[0];
        }

        public void store(PortletWindow window,
                          PortletRequest req,
                          PortletPreference[] preferences) throws PortletContainerException {

        }
    }


    public PortletEnvironmentService getPortletEnvironmentService() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public PortletInvokerService getPortletInvokerService(InternalPortletWindow window) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}

