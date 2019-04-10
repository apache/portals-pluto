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

import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.pluto.container.RequestDispatcherService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version $Id$
 *
 */
public class RequestDispatcherServiceImpl implements RequestDispatcherService
{
    /**
     *  Logger.
     */
    
    private static final Logger LOG = LoggerFactory.getLogger(RequestDispatcherServiceImpl.class);
    
    public RequestDispatcherServiceImpl()
    {
    }
    
    public PortletRequestDispatcher getNamedDispatcher(ServletContext servletContext, PortletApplicationDefinition app,
                                                       String name)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Named PortletRequestDispatcher requested for name: "+name+" at context: "+app.getContextPath());
        }
        
        RequestDispatcher dispatcher = servletContext.getNamedDispatcher(name);
        if (dispatcher != null)
        {
            return new PortletRequestDispatcherImpl(dispatcher, name, true);
        }
        if (LOG.isInfoEnabled())
        {
            LOG.info("No matching request dispatcher found for name: "+ name);
        }
        return null;
    }

    public PortletRequestDispatcher getRequestDispatcher(ServletContext servletContext,
                                                         PortletApplicationDefinition app, String path)
    {
        if (LOG.isDebugEnabled())
        {
            LOG.debug("PortletRequestDispatcher requested for path: " + path+" at context: "+app.getContextPath());
        }
        
        // Check if the path name is valid. A valid path name must not be null
        //   and must start with a slash '/' as defined by the portlet spec.
        if (path == null || !path.startsWith("/"))
        {
            if (LOG.isInfoEnabled())
            {
                LOG.info("Failed to retrieve PortletRequestDispatcher: path name must begin with a slash '/'.");
            }
            return null;
        }
        
        // Construct PortletRequestDispatcher.
        PortletRequestDispatcher portletRequestDispatcher = null;
        try 
        {
            RequestDispatcher servletRequestDispatcher = servletContext.getRequestDispatcher(path);
            if (servletRequestDispatcher != null) 
            {
                portletRequestDispatcher = new PortletRequestDispatcherImpl(servletRequestDispatcher, path, false);
            } 
            else 
            {
                if (LOG.isInfoEnabled()) 
                {
                    LOG.info("No matching request dispatcher found for: " + path);
                }
            }
        } 
        catch (Exception ex) 
        {
            // We need to catch exception because of a Tomcat 4.x bug.
            //   Tomcat throws an exception instead of return null if the path
            //   was not found.
            if (LOG.isInfoEnabled())
            {
                LOG.info("Failed to retrieve PortletRequestDispatcher: "+ ex.getMessage());
            }
            portletRequestDispatcher = null;
        }
        return portletRequestDispatcher;
    }
}
