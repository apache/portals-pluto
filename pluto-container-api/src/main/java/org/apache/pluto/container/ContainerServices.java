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
package org.apache.pluto.container;

import javax.portlet.PortalContext;

/**
 * This interface defines the services required for integration between the
 * Pluto Portlet Container and a Portal.
 */
public interface ContainerServices {

    /**
     * Returns the PortalContext instance associated with this group of
     * portlet container services.
     * @return a PortalContext implementation.
     */
    PortalContext getPortalContext();

    EventCoordinationService getEventCoordinationService();

    /**
     * Returns the portlet request context service implementation
     * used by the container
     */
    PortletRequestContextService getPortletRequestContextService();

    /**
     * Returns the FilterManagerService
     */
    FilterManagerService getFilterManagerService();

    /**
     * Returns the PortletURLListenerService
     */
    PortletURLListenerService getPortletURLListenerService();

    /**
     * Returns the portlet preferences service implementation
     * used by the container.
     *
     * @return portlet preferences service implementation.
     */
    PortletPreferencesService getPortletPreferencesService();

    /**
     * Returns the environment services implementation
     * used by the container.
     *
     * @return portlet environment services implementation.
     */
    PortletEnvironmentService getPortletEnvironmentService();

    /**
     * Returns an invoker for the specified PortletWindow.
     *
     * @return an invoker which can be used to service the indicated portlet.
     */
    PortletInvokerService getPortletInvokerService();

    /**
     * Returns the user info service implementation used
     * by the container.
     *
     * @return user info service
     */
    UserInfoService getUserInfoService();

    /**
     * Returns the NamespaceMapper used to retrieve the Portal
     * specific PortletWindow namespace and encoding/decoding
     * of PortletWindow parameters in a PortalURL
     */
    NamespaceMapper getNamespaceMapper();

    /**
     * Returns the CC/PP profile service implementation
     * @return a CCPPProfileServiceImplementation
     */
    CCPPProfileService getCCPPProfileService();
    
    /**
     * Returns the RequestDispatcher service implementation
     * @return a RequestDispatcherService implementation
     */
    RequestDispatcherService getRequestDispatcherService();
}
