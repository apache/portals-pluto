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
package org.apache.pluto.container;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public interface PortletRequestContextService {
   PortletRequestContext getPortletActionRequestContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, PortletWindow window);

   PortletRequestContext getPortletEventRequestContext(PortletContainer container, HttpServletRequest containerRequest,
         HttpServletResponse containerResponse, PortletWindow window);

   PortletResourceRequestContext getPortletResourceRequestContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, PortletWindow window);

   PortletRequestContext getPortletHeaderRequestContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, PortletWindow window);

   PortletRequestContext getPortletRenderRequestContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, PortletWindow window);

   PortletActionResponseContext getPortletActionResponseContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, 
         PortletWindow window, PortletRequestContext requestContext);

   PortletEventResponseContext getPortletEventResponseContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, 
         PortletWindow window, PortletRequestContext requestContext);

   PortletResourceResponseContext getPortletResourceResponseContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, 
         PortletWindow window, PortletRequestContext requestContext);

   PortletRenderResponseContext getPortletRenderResponseContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, 
         PortletWindow window, PortletRequestContext requestContext);

   PortletHeaderResponseContext getPortletHeaderResponseContext(PortletContainer container,
         HttpServletRequest containerRequest, HttpServletResponse containerResponse, 
         PortletWindow window, PortletRequestContext requestContext);
}
