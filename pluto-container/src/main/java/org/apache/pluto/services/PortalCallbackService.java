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

package org.apache.pluto.services;

import javax.servlet.http.HttpServletRequest;

import org.apache.pluto.PortletWindow;

import java.util.Map;

/**
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 * @version 1.0
 * @since Sep 21, 2004
 */
public interface PortalCallbackService extends ContainerService {

    /**
     * Set the title to be used for this portlet.
     * @param request
     * @param window
     * @param title
     */
    public void setTitle(HttpServletRequest request,
                         PortletWindow window,
                         String title);

    /**
     * Returns an URL pointing to the given portlet window
     * @param portletWindow the portlet Window
     * @return the URL to the given portlet
     */
    public PortletURLProvider getPortletURLProvider(HttpServletRequest req,
                                                    PortletWindow portletWindow);

    /**
     * Returns the ResourceURLProvider to create URLs pointing to a resource in
     * a web application.
     * @param portletWindow the portlet Window
     * @return the URL to a resource
     */
    public ResourceURLProvider getResourceURLProvider(HttpServletRequest req,
                                                      PortletWindow portletWindow);

    public Map getRequestProperties(HttpServletRequest req,
                                    PortletWindow portletWindow);

    public void setResponseProperty(HttpServletRequest req,
                                    PortletWindow window,
                                    String property, String value);

    public void addResponseProperty(HttpServletRequest req,
                                    PortletWindow window,
                                    String property, String value);

}
