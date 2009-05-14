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

import javax.portlet.PortletMode;
import javax.portlet.WindowState;

import org.apache.pluto.container.om.portlet.PortletDefinition;


/**
 * Thin representation of the portlet window for which the container
 * request should be processed.  The PortletWindow is used internally
 * to map the request to the configured Portlet Application and Portlet.
 *
 * @see org.apache.pluto.container.om.portlet.PortletDefinition
 *
 * @version 1.0
 * @since Sep 22, 2004
 */
public interface PortletWindow {

    /**
     * Retrieve this windows unique id which will be
     *  used to communicate back to the referencing portal.
     * @return unique id.
     */
    PortletWindowID getId();

    /**
     * Retrieve the current window state for this window.
     * @return the current window state.
     */
    WindowState getWindowState();

    /**
     * Retrieve the current portlet mode for this window.
     * @return the current portlet mode.
     */
    PortletMode getPortletMode();

    /**
     * Returns the portlet description. The return value cannot be NULL.
     * @return the portlet description.
     */
    PortletDefinition getPortletDefinition();
}
