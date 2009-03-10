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

package org.apache.pluto.container.impl;

import org.apache.pluto.container.RequestDispatcherPathInfo;

/**
 * @author <a href="mailto:ate@douma.nu">Ate Douma</a>
 * @version $Id$
 */
public class RequestDispatcherPathInfoImpl implements RequestDispatcherPathInfo
{
    private final boolean named;
    private final String requestURI;
    private final String servletPath;
    private final String pathInfo;
    private final String queryString;
    
    public RequestDispatcherPathInfoImpl()
    {
        named = true;
        this.requestURI = null;
        this.servletPath = null;
        this.pathInfo = null;
        this.queryString = null;
    }
    
    public RequestDispatcherPathInfoImpl(String contextPath, String servletPath, String pathInfo, String queryString)
    {
        this.named = false;
        this.requestURI = contextPath + (servletPath != null ? servletPath : "") + (pathInfo != null ? pathInfo : "");
        this.servletPath = servletPath;
        this.pathInfo = pathInfo;
        this.queryString = queryString;
    }
    
    public boolean isNamedRequestDispatcher()
    {
        return named;
    }

    public String getRequestURI()
    {
        return requestURI;
    }

    public String getServletPath()
    {
        return servletPath;
    }

    public String getPathInfo()
    {
        return pathInfo;
    }

    public String getQueryString()
    {
        return queryString;
    }
}
