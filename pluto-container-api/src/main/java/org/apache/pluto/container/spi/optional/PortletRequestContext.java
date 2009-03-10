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

package org.apache.pluto.container.spi.optional;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.InternalPortletConfig;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public interface PortletRequestContext
{
    void init(InternalPortletConfig portletConfig);
    PortletContainer getContainer();
    InternalPortletConfig getPortletConfig();
    HttpServletRequest getServletRequest();
    HttpServletResponse getServletResponse();
    PortletWindow getPortletWindow();
    
    Enumeration<String> getAttributeNames();
    Object getAttribute(String name);
    void setAttribute(String name, Object value);

    Locale getPreferredLocale();
    Cookie[] getCookies();
    Map<String, String[]> getProperties();
    
    Map<String, String[]> getPrivateParameterMap();
    Map<String, String[]> getPublicParameterMap();
}
