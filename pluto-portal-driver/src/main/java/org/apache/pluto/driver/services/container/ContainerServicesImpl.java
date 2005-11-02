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
package org.apache.pluto.driver.services.container;

import org.apache.pluto.OptionalPortletContainerServices;
import org.apache.pluto.services.PortalCallbackService;
import org.apache.pluto.PortletContainerServices;
import org.apache.pluto.services.PortletPreferencesService;

import javax.portlet.PortalContext;

/**
 * The Portal Driver's <code>PortletContainerServices</code> implementation. The
 * <code>PortletContainerServices</code> interface is the main integration point
 * between the pluto container and the surrounding portal.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 21, 2004
 */
public class ContainerServicesImpl
    implements PortletContainerServices, OptionalPortletContainerServices {


    private PortalContextImpl context;

    private PortletPreferencesService preferencesFactory;
    private PortalCallbackService callback;

    /**
     * Default Constructor.
     */
    public ContainerServicesImpl(PortalContextImpl context) {
        this.context = context;
        preferencesFactory = new PortletPreferencesProviderImpl();
        callback = new PortalCallbackProviderImpl();
    }

    /**
     * Standard Getter.
     * @return the portal context for the portal which we service.
     */
    public PortalContext getPortalContext() {
        return context;
    }

    /**
     * The PortletPreferencesService provides access to the portal's
     * PortletPreference persistence mechanism.
     * @return a PortletPreferencesService instance.
     */
    public PortletPreferencesService getPortletPreferencesService() {
        return preferencesFactory;
    }

    /**
     * The PortalCallbackService allows the container to communicate
     * actions back to the portal.
     * @return a PortalCallbackService implementation.
     */
    public PortalCallbackService getPortalCallbackService() {
        return callback;
    }

}

