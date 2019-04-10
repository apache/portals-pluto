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
package org.apache.pluto.driver.services.portal;

import java.util.Set;

import javax.portlet.WindowState;

import org.apache.pluto.container.PortletContainerException;

/**
 * Allows clients to see if a particular WindowState is supported by
 * the portal, a particular portlet, or both.
 *
 * @since Feb 27, 2007
 * @version $Id$
 * @see javax.portlet.WindowState
 */
public interface SupportedWindowStateService {

    /**
     * Returns true if the portlet and the portal support the supplied
     * window state.
     * @param portletId the id uniquely identifying the portlet
     * @param state the portlet window state
     * @return true if the portlet and portal both support the supplied window state
     */
    boolean isWindowStateSupported( String portletId, String state );

    /**
     * Returns true if the portal supports the supplied window state.
     * @param state the portlet window state
     * @return true if the portal supports the supplied window state
     */
    boolean isWindowStateSupportedByPortal( String state );

    /**
     * Returns true if the portlet supports the supplied window state.
     * @param portletId the id uniquely identifying the portlet
     * @param state the window state
     * @return true if the portlet support the supplied state
     */
    boolean isWindowStateSupportedByPortlet( String portletId, String state );

    /**
     * Gets all window states supported by a portlet according to the deployment descriptor. 
     * in portlet.xml.
     * 
     * @param portletId Id of the portlet of interest
     * @param The content type, in general will be "text/html"
     * @return all window states supported by a portlet.
     * @throws PortletContainerException
      */
     Set<WindowState> getSupportedWindowStates(String portletId, String contentType) throws PortletContainerException;

}
