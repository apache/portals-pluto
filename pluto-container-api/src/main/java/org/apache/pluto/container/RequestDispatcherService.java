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

import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * Service to retrieve a RequestDispatcher and corresponding HttpServletRequest and HttpServletResponse wrappers
 * for usage by the PortletContext and to support custom Servlet Request dispatching.
 * 
 * @version $Id$
 */
public interface RequestDispatcherService
{
    PortletRequestDispatcher getRequestDispatcher(ServletContext servletContext, PortletApplicationDefinition app,
                                                  String path);

    PortletRequestDispatcher getNamedDispatcher(ServletContext servletContext, PortletApplicationDefinition app,
                                                String name);

    HttpServletRequestWrapper getRequestWrapper(ServletContext servletContext, HttpServletRequest servletRequest,
                                                PortletRequest portletRequest, HttpSession session, boolean included,
                                                boolean named);

    HttpServletResponseWrapper getResponseWraper(ServletContext servletContext, HttpServletResponse servletResponse,
                                                 PortletRequest portletRequest, PortletResponse portletResponse,
                                                 boolean included);
}
