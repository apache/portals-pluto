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

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.Event;
import javax.portlet.PortletMode;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.container.spi.optional.PortletStateAwareResponseContext;

/**
 * @version $Id$
 *
 */
public abstract class PortletStateAwareResponseContextImpl extends PortletResponseContextImpl implements
                PortletStateAwareResponseContext
{
    public PortletStateAwareResponseContextImpl(PortletContainer container, HttpServletRequest request,
                                                HttpServletResponse response, PortletWindow window)
    {
        super(container, request, response, window);
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#getEvents()
     */
    public List<Event> getEvents()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#getPortletMode()
     */
    public PortletMode getPortletMode()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#getRemovedPublicRenderParameters()
     */
    public Set<String> getRemovedPublicRenderParameters()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#getRenderParameters()
     */
    public Map<String, String[]> getRenderParameters()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#getWindowState()
     */
    public WindowState getWindowState()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#setPortletMode(javax.portlet.PortletMode)
     */
    public void setPortletMode(PortletMode portletMode)
    {
        // TODO Auto-generated method stub
    }

    /* (non-Javadoc)
     * @see org.apache.pluto.spi.optional.PortletStateAwareResponseContext#setWindowState(javax.portlet.WindowState)
     */
    public void setWindowState(WindowState windowState)
    {
        // TODO Auto-generated method stub
    }
}
