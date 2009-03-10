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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pluto.container.PortletContainer;
import org.apache.pluto.container.PortletWindow;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public interface PortletRequestContextService
{
    PortletRequestContext getPortletActionRequestContext(PortletContainer container, HttpServletRequest request,
                                                         HttpServletResponse response, PortletWindow window);

    PortletRequestContext getPortletEventRequestContext(PortletContainer container, HttpServletRequest request,
                                                        HttpServletResponse response, PortletWindow window);

    PortletResourceRequestContext getPortletResourceRequestContext(PortletContainer container,
                                                                   HttpServletRequest request,
                                                                   HttpServletResponse response, PortletWindow window);

    PortletRequestContext getPortletRenderRequestContext(PortletContainer container, HttpServletRequest request,
                                                         HttpServletResponse response, PortletWindow window);

    PortletActionResponseContext getPortletActionResponseContext(PortletContainer container,
                                                                 HttpServletRequest request,
                                                                 HttpServletResponse response, PortletWindow window);

    PortletEventResponseContext getPortletEventResponseContext(PortletContainer container, HttpServletRequest request,
                                                               HttpServletResponse response, PortletWindow window);

    PortletResourceResponseContext getPortletResourceResponseContext(PortletContainer container,
                                                                     HttpServletRequest request,
                                                                     HttpServletResponse response, PortletWindow window);

    PortletRenderResponseContext getPortletRenderResponseContext(PortletContainer container,
                                                                 HttpServletRequest request,
                                                                 HttpServletResponse response, PortletWindow window);
}
