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

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;
import org.apache.pluto.driver.core.PortalEnvironment;
import org.apache.pluto.driver.core.ResourceURLProviderImpl;
import org.apache.pluto.services.PortalCallbackService;
import org.apache.pluto.services.PortletURLProvider;
import org.apache.pluto.services.ResourceURLProvider;

import java.util.Map;
import java.util.Collections;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 22, 2004
 */
public class PortalCallbackServiceImpl implements PortalCallbackService {


    public PortalCallbackServiceImpl() {

    }

    public void setTitle(HttpServletRequest request,
                         PortletWindow window,
                         String title) {
        request.setAttribute("org.apache.pluto.dynamic_title", title);
    }

    public PortletURLProvider getPortletURLProvider(
        HttpServletRequest req, PortletWindow internalPortletWindow) {
        return new PortletURLProviderImpl(req, internalPortletWindow);
    }

    public ResourceURLProvider getResourceURLProvider(
        HttpServletRequest req, PortletWindow internalPortletWindow) {
        return new ResourceURLProviderImpl(req, internalPortletWindow);
    }

    public Map getRequestProperties(HttpServletRequest req, PortletWindow portletWindow) {
        return Collections.EMPTY_MAP;
    }

    public void setResponseProperty(HttpServletRequest req, PortletWindow window, String property, String value) {

    }

    public void addResponseProperty(HttpServletRequest req, PortletWindow window, String property, String value) {

    }
}

