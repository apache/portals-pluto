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

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.pluto.container.ContainerInfo;
import org.apache.pluto.container.RequestDispatcherService;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * Default Portlet Context Implementation.
 * 
 * @version $Id$
 */
public class PortletContextImpl implements PortletContext
{
    // Private Member Variables ------------------------------------------------
    
    protected ServletContext servletContext;
    protected PortletApplicationDefinition portletApp;
    protected ContainerInfo containerInfo;
    protected List<String> supportedContainerRuntimeOptions;
    protected RequestDispatcherService rdService;

    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param servletContext  the servlet context in which we are contained.
     * @param portletApp  the portlet application descriptor.
     */
    public PortletContextImpl(ServletContext servletContext,
                              PortletApplicationDefinition portletApp, 
                              ContainerInfo containerInfo, 
                              List<String> supportedContainerRuntimeOptions,
                              RequestDispatcherService rdService)
    {
        this.servletContext = servletContext;
        this.portletApp = portletApp;
        this.containerInfo = containerInfo;
        this.supportedContainerRuntimeOptions = supportedContainerRuntimeOptions;
        this.rdService = rdService;
    }
    
    // PortletContext Impl -----------------------------------------------------
    
    /**
     * Retrieve the PortletContainer's server info.
     * @return the server info in the form of <i>Server/Version</i>
     */
    public String getServerInfo() {
        return containerInfo.getServerInfo();
    }
    
    public PortletRequestDispatcher getRequestDispatcher(String path)
    {
        return rdService.getRequestDispatcher(servletContext, portletApp, path);
    }
    
    public PortletRequestDispatcher getNamedDispatcher(String name)
    {
        return rdService.getNamedDispatcher(servletContext, portletApp, name);
    }

    public InputStream getResourceAsStream(String path) {
        return servletContext.getResourceAsStream(path);
    }

    public int getMajorVersion() {
        return containerInfo.getMajorSpecificationVersion();
    }

    public int getMinorVersion() {
        return containerInfo.getMinorSpecificationVersion();
    }

    public String getMimeType(String file) {
        return servletContext.getMimeType(file);
    }

    public String getRealPath(String path) {
        return servletContext.getRealPath(path);
    }

    @SuppressWarnings("unchecked")
    public Set<String> getResourcePaths(String path) {
        return servletContext.getResourcePaths(path);
    }

    public URL getResource(String path)
        throws java.net.MalformedURLException {
        if (path == null || !path.startsWith("/")) {
            throw new MalformedURLException("path must start with a '/'");
        }
        return servletContext.getResource(path);
    }

    public Object getAttribute(java.lang.String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        return servletContext.getAttribute(name);
    }

    @SuppressWarnings("unchecked")
    public Enumeration<String> getAttributeNames() {
        return servletContext.getAttributeNames();
    }

    public String getInitParameter(java.lang.String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        return servletContext.getInitParameter(name);
    }

    @SuppressWarnings("unchecked")
    public Enumeration<String> getInitParameterNames() {
        return servletContext.getInitParameterNames();
    }

    public void log(java.lang.String msg) {
        servletContext.log(msg);
    }

    public void log(java.lang.String message, Throwable throwable) {
        servletContext.log(message, throwable);
    }

    public void removeAttribute(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        servletContext.removeAttribute(name);
    }

    public void setAttribute(String name, Object object) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        servletContext.setAttribute(name, object);
    }

    public String getPortletContextName() {
        return servletContext.getServletContextName();
    }
    
    
    public ServletContext getServletContext() {
        return servletContext;
    }

    public PortletApplicationDefinition getPortletApplicationDefinition() {
        return portletApp;
    }

	public Enumeration<String> getContainerRuntimeOptions() {
	    return Collections.enumeration(supportedContainerRuntimeOptions);
	}
}

