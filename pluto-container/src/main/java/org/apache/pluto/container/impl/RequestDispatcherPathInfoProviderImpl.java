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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletContext;

import org.apache.pluto.container.RequestDispatcherPathInfo;
import org.apache.pluto.container.RequestDispatcherPathInfoProvider;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * @version $Id$
 *
 */
public class RequestDispatcherPathInfoProviderImpl implements RequestDispatcherPathInfoProvider
{
    protected List<String> exactServletMappingURLPatterns = new ArrayList<String>();
    protected List<String> pathServletMappingURLPatterns = new ArrayList<String>();
    protected boolean defaultServletMapping = false;
    
    private RequestDispatcherPathInfoProviderImpl(Set<String> servletMappingURLPatterns)
    {
        for (String pat : servletMappingURLPatterns)
        {                 
            if (pat.startsWith("/"))
            {
                if (pat.equals("/") || pat.equals("/*"))
                {
                    defaultServletMapping = true;
                }
                else if (pat.endsWith("/*"))
                {
                    pathServletMappingURLPatterns.add(pat.substring(0,pat.length()-2));
                }
                else
                {
                    exactServletMappingURLPatterns.add(pat);
                }
            }
            else if (pat.startsWith("*."))
            {                
                // ignore, will always fallback on full path servlet mapping
            }
            else
            {
                exactServletMappingURLPatterns.add(pat);
            }
        }
    }
    
    public static RequestDispatcherPathInfoProvider getProvider(PortletContext portletContext, PortletApplicationDefinition app)
    {
        RequestDispatcherPathInfoProvider provider = (RequestDispatcherPathInfoProvider)portletContext.getAttribute(CONTEXT_KEY);
        if (provider == null)
        {
            provider = new RequestDispatcherPathInfoProviderImpl(app.getServletMappingURLPatterns());
            portletContext.setAttribute(CONTEXT_KEY, provider);
        }
        return provider;
    }
    
    public RequestDispatcherPathInfo getNamedRequestDispatcherPathInfo()
    {
        return new RequestDispatcherPathInfoImpl();
    }

    public RequestDispatcherPathInfo getPathInfo(String contextPath, String path)
    {
        String servletPath = null;
        String pathInfo = null;
        String queryString = null;
        
        int index = path.indexOf('?');
        if (index != -1)
        {
            queryString = path.substring(index+1, path.length());
            path = path.substring(0, index);
        }
        
        if (exactServletMappingURLPatterns.contains(path))
        {
            servletPath = path;
        }
        else if (path.length() == 1 && defaultServletMapping)
        {
            servletPath = path;
        }
        else
        {
            String sub = path;
            index = path.lastIndexOf('/');
            while (index > 0)
            {
                sub = sub.substring(0, index);
                if (pathServletMappingURLPatterns.contains(sub))
                {
                    servletPath = sub;
                    if (sub.length() < path.length())
                    {
                        pathInfo = path.substring(sub.length());
                    }
                    break;
                }
                index = sub.lastIndexOf('/');
            }
        }
        // no need to check for *. extension mapping as it simply means full path to servlet mapping
        // which is already the default / catch-all solution
        if (servletPath == null)
        {
            servletPath = path;            
        }
        
        return new RequestDispatcherPathInfoImpl(contextPath,servletPath,pathInfo,queryString);
    }
}
