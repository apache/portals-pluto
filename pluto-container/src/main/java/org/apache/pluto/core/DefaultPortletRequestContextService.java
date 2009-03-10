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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletActionResponseContext;
import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletEventResponseContext;
import org.apache.pluto.container.PortletRenderResponseContext;
import org.apache.pluto.container.PortletRequestContext;
import org.apache.pluto.container.PortletRequestContextService;
import org.apache.pluto.container.PortletResourceRequestContext;
import org.apache.pluto.container.PortletResourceResponseContext;
import org.apache.pluto.container.PortletWindow;
import org.apache.pluto.spi.impl.PortletRenderResponseContextImpl;
import org.apache.pluto.spi.impl.PortletActionResponseContextImpl;
import org.apache.pluto.spi.impl.PortletEventResponseContextImpl;
import org.apache.pluto.spi.impl.PortletRequestContextImpl;
import org.apache.pluto.spi.impl.PortletResourceRequestContextImpl;
import org.apache.pluto.spi.impl.PortletResourceResponseContextImpl;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class DefaultPortletRequestContextService implements PortletRequestContextService
{
    public PortletRequestContext getPortletActionRequestContext(PortletContainer container, HttpServletRequest request,
                                                                HttpServletResponse response, PortletWindow window)
    {
        return new PortletRequestContextImpl(container, request, response, window);
    }

    public PortletActionResponseContext getPortletActionResponseContext(PortletContainer container,
                                                                        HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        PortletWindow window)
    {
        return new PortletActionResponseContextImpl(container, request, response, window);
    }

    public PortletRequestContext getPortletEventRequestContext(PortletContainer container, HttpServletRequest request,
                                                               HttpServletResponse response, PortletWindow window)
    {
        return new PortletRequestContextImpl(container, request, response, window);
    }

    public PortletEventResponseContext getPortletEventResponseContext(PortletContainer container,
                                                                      HttpServletRequest request,
                                                                      HttpServletResponse response, PortletWindow window)
    {
        return new PortletEventResponseContextImpl(container, request, response, window);
    }

    public PortletRequestContext getPortletRenderRequestContext(PortletContainer container, HttpServletRequest request,
                                                                HttpServletResponse response, PortletWindow window)
    {
        return new PortletRequestContextImpl(container, request, response, window);
    }

    public PortletRenderResponseContext getPortletRenderResponseContext(PortletContainer container,
                                                                        HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        PortletWindow window)
    {
        return new PortletRenderResponseContextImpl(container, request, response, window);
    }

    public PortletResourceRequestContext getPortletResourceRequestContext(PortletContainer container,
                                                                          HttpServletRequest request,
                                                                          HttpServletResponse response,
                                                                          PortletWindow window)
    {
        return new PortletResourceRequestContextImpl(container, request, response, window);
    }

    public PortletResourceResponseContext getPortletResourceResponseContext(PortletContainer container,
                                                                            HttpServletRequest request,
                                                                            HttpServletResponse response,
                                                                            PortletWindow window)
    {
        return new PortletResourceResponseContextImpl(container, request, response, window);
    }
}
