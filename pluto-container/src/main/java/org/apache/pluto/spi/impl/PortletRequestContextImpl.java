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

package org.apache.pluto.spi.impl;

import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.ContainerPortletConfig;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletWindow;

/**
 * @version $Id$
 *
 */
public class PortletRequestContextImpl implements PortletRequestContext
{
    private PortletContainer container;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PortletWindow window;
    
    public PortletRequestContextImpl(PortletContainer container, HttpServletRequest request,
                                     HttpServletResponse response, PortletWindow window)
    {
        this.container = container;
        this.request = request;
        this.response = response;
        this.window = window;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getAttribute(java.lang.String)
     */
    public Object getAttribute(String name)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getAttributeNames()
     */
    public Enumeration<String> getAttributeNames()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getContainer()
     */
    public PortletContainer getContainer()
    {
        return container;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getCookies()
     */
    public Cookie[] getCookies()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getPortletConfig()
     */
    public ContainerPortletConfig getPortletConfig()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getPortletWindow()
     */
    public PortletWindow getPortletWindow()
    {
        return window;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getPreferredLocale()
     */
    public Locale getPreferredLocale()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getPrivateParameterMap()
     */
    public Map<String, String[]> getPrivateParameterMap()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getProperties()
     */
    public Map<String, String[]> getProperties()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getPublicParameterMap()
     */
    public Map<String, String[]> getPublicParameterMap()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getServletRequest()
     */
    public HttpServletRequest getServletRequest()
    {
        return request;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#getServletResponse()
     */
    public HttpServletResponse getServletResponse()
    {
        return response;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#init(org.apache.pluto.internal.InternalPortletConfig)
     */
    public void init(ContainerPortletConfig portletConfig)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletRequestContext#setAttribute(java.lang.String, java.lang.Object)
     */
    public void setAttribute(String name, Object value)
    {
        // TODO Auto-generated method stub
    }
}
