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

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.spi.optional.PortletActionResponseContext;
import org.apache.pluto.spi.optional.PortletEventResponseContext;
import org.apache.pluto.spi.optional.PortletRenderResponseContext;
import org.apache.pluto.spi.optional.PortletRequestContext;
import org.apache.pluto.spi.optional.PortletRequestContextService;
import org.apache.pluto.spi.optional.PortletResourceRequestContext;
import org.apache.pluto.spi.optional.PortletResourceResponseContext;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class DefaultPortletRequestContextService implements PortletRequestContextService
{
    public PortletRequestContext getPortletActionRequestContext(PortletContainer container, HttpServletRequest request,
                                                                HttpServletResponse response, PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletActionResponseContext getPortletActionResponseContext(PortletContainer container,
                                                                        HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletRequestContext getPortletEventRequestContext(PortletContainer container, HttpServletRequest request,
                                                               HttpServletResponse response, PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletEventResponseContext getPortletEventResponseContext(PortletContainer container,
                                                                      HttpServletRequest request,
                                                                      HttpServletResponse response, PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletRequestContext getPortletRenderRequestContext(PortletContainer container, HttpServletRequest request,
                                                                HttpServletResponse response, PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletRenderResponseContext getPortletRenderResponseContext(PortletContainer container,
                                                                        HttpServletRequest request,
                                                                        HttpServletResponse response,
                                                                        PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletResourceRequestContext getPortletResourceRequestContext(PortletContainer container,
                                                                          HttpServletRequest request,
                                                                          HttpServletResponse response,
                                                                          PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }

    public PortletResourceResponseContext getPortletResourceResponseContext(PortletContainer container,
                                                                            HttpServletRequest request,
                                                                            HttpServletResponse response,
                                                                            PortletWindow window)
    {
        // TODO Auto-generated method stub
        return null;
    }
}
