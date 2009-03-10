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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.w3c.dom.Element;

/**
 * @version $Id$
 *
 */
public abstract class PortletResponseContextImpl implements PortletResponseContext
{
    private PortletContainer container;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private PortletWindow window;
    
    public PortletResponseContextImpl(PortletContainer container, HttpServletRequest request,
                                      HttpServletResponse response, PortletWindow window)
    {
        this.container = container;
        this.request = request;
        this.response = response;
        this.window = window;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#addProperty(javax.servlet.http.Cookie)
     */
    public void addProperty(Cookie cookie)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#addProperty(java.lang.String, org.w3c.dom.Element)
     */
    public void addProperty(String key, Element element)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#addProperty(java.lang.String, java.lang.String)
     */
    public void addProperty(String key, String value)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#close()
     */
    public void close()
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#getContainer()
     */
    public PortletContainer getContainer()
    {
        return container;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#getPortletWindow()
     */
    public PortletWindow getPortletWindow()
    {
        return window;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#getServletRequest()
     */
    public HttpServletRequest getServletRequest()
    {
        return request;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#getServletResponse()
     */
    public HttpServletResponse getServletResponse()
    {
        return response;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#release()
     */
    public void release()
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletResponseContext#setProperty(java.lang.String, java.lang.String)
     */
    public void setProperty(String key, String value)
    {
        // TODO Auto-generated method stub
    }
}
