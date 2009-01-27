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

package org.apache.pluto.core;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.spi.PropertyManager;
import org.w3c.dom.Element;

/**
 * @version $Id$
 *
 */
public class DefaultPropertyManager implements PropertyManager
{
    public Map<String, String[]> getRequestProperties(HttpServletRequest request, PortletWindow portletWindow)
    {
        HashMap<String, String[]> properties = new HashMap<String, String[]>();
        for (Enumeration<String> names = request.getHeaderNames(); names.hasMoreElements(); )
        {
            String name = names.nextElement();
            ArrayList<String> values = new ArrayList<String>();
            for (Enumeration<String> headers = request.getHeaders(name); headers.hasMoreElements(); )
            {
                values.add(headers.nextElement());
            }
            int size = values.size();
            if (size > 0)
            {
                properties.put(name, values.toArray(new String[size]));
            }
        }
        return properties;
    }

    public Cookie[] getRequestCookies(HttpServletRequest request, PortletWindow portletWindow)
    {
        return request.getCookies();
    }

    public void addResponseProperty(HttpServletRequest request, HttpServletResponse response,
                                    PortletWindow portletWindow, PortletContainer.Method method, String property, String value)
    {
        switch (method)
        {
            case RESOURCE: response.addHeader(property, value);
                break;
            default:
                break;
        }
    }

    public void addResponseProperty(HttpServletRequest request, HttpServletResponse response,
                                    PortletWindow portletWindow, PortletContainer.Method method, String property, Element value)
    {
    }

    public void addResponseProperty(HttpServletRequest request, HttpServletResponse response,
                                    PortletWindow portletWindow, PortletContainer.Method method, Cookie cookie)
    {
        response.addCookie(cookie);
    }

    public void setResponseProperty(HttpServletRequest request, HttpServletResponse response,
                                    PortletWindow portletWindow, PortletContainer.Method method, String property, String value)
    {
        switch (method)
        {
            case RESOURCE: response.setHeader(property, value);
                break;
            default:
                break;
        }
    }
}
