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

import org.apache.pluto.services.*;

import javax.portlet.PortalContext;
import javax.servlet.http.HttpServletRequest;

/**
 * The Portal Driver's <code>PortletContainerServices</code> implementation. The
 * <code>PortletContainerServices</code> interface is the main integration point
 * between the pluto container and the surrounding portal.
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 21, 2004
 */
public class ContainerServicesImpl implements PortletContainerServices {


    private PortalContextImpl context;

    private PortletPreferencesFactory preferencesFactory;
    private PortalCallbackProvider callback;
    private PropertyManagerService propertyService;

    /**
     * Default Constructor.
     */
    public ContainerServicesImpl(PortalContextImpl context) {
        this.context = context;
        preferencesFactory = new PortletPreferencesProviderImpl();
        callback = new PortalCallbackProviderImpl();
        propertyService = new PropertyManagerProviderImpl();
    }

    /**
     * Standard Getter.
     * @return the portal context for the portal which we service.
     */
    public PortalContext getPortalContext() {
        return context;
    }

    /**
     * The PortletPreferencesFactory provides access to the portal's
     * PortletPreference persistence mechanism.
     * @return a PortletPreferencesFactory instance.
     */
    public PortletPreferencesFactory getPortletPreferencesFactory() {
        return preferencesFactory;
    }

    /**
     * The DynamicInformationProvider provides dynamic, runtime evaluated,
     * information.
     * @param req the HttpServletRequest identifying the request
     * @return a DynamicInformationProvider implementation.
     */
    public DynamicInformationProvider getDynamicInformationProvider(
        HttpServletRequest req) {
        return new DynamicInformationProviderImpl(req);
    }


    /**
     * The PortalCallbackProvider allows the container to communicate
     * actions back to the portal.
     * @return a PortalCallbackProvider implementation.
     */
    public PortalCallbackProvider getPortalCallbackProvider() {
        return callback;
    }

    /**
     * The PropertyManagerService manages portal properties.
     * @return a PropertyManagerService implemenatation.
     */
    public PropertyManagerService getPropertyManagerService() {
        return this.propertyService;
    }


}

