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
package org.apache.pluto.container.driver;

import org.apache.pluto.container.CCPPProfileService;
import org.apache.pluto.container.NamespaceMapper;
import org.apache.pluto.container.PortletEnvironmentService;
import org.apache.pluto.container.PortletInvokerService;
import org.apache.pluto.container.PortletPreferencesService;
import org.apache.pluto.container.RequestDispatcherService;
import org.apache.pluto.container.UserInfoService;

/**
 * Defines the services necessary for integration between the Pluto Container
 * and a Portal.
 *
 * <p>NOTE: Backwards compatibility is not garaunteed against
 * this interface as additional services may be needed.
 * Please extend the DefaultOptionalContainerServices
 * class to ensure your implementation can be used without
 * modicications in the future.</p>
 *
 * @since 1.1.0
 */
public interface OptionalContainerServices {

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
     * Returns the RequestDispatcherService
     */
    RequestDispatcherService getRequestDispatcherService();
}
