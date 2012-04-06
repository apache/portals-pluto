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

/**
 * Used to inform a {@link PortletServlet} that registration has been completed
 * 
 * @author Eric Dalquist
 */
public interface PortletServletLifecycleCallback {
    /**
     * Called after the container has completely registered the portlet. This may be called in a different thread than called
     * {@link PlutoServicesRegistry#register(javax.servlet.ServletConfig, ClassLoader, PortletRegistrationCallback)} meaning
     * implementations and data structures they modify need to be thread-safe
     */
    void registered(PortalDriverContainerServices portalDriverServices, DriverPortletContext portletContext, DriverPortletConfig portletConfig);
    
    /**
     * Called after the container has completely registered the portlet. This may be called in a different thread than called
     * {@link PlutoServicesRegistry#unregister(javax.servlet.ServletConfig, DriverPortletContext)} meaning implementations and
     * data structures they modify need to be thread-safe
     */
    void unregistered();
}
