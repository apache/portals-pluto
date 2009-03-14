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
package org.apache.pluto.container.driver.impl;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.container.RequestDispatcherPathInfoProvider;
import org.apache.pluto.container.driver.DriverPortletContext;
import org.apache.pluto.container.impl.PortletRequestDispatcherImpl;
import org.apache.pluto.container.impl.RequestDispatcherPathInfoProviderImpl;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * Pluto's Portlet Context Implementation. This class implements the
 * <code>InternalPortletContext</code> which provides container specific
 * information needed for processing.
 * 
 * @version 1.1
 */
public class PortletContextImpl
implements PortletContext, DriverPortletContext {
	
	/**
	 *  Logger.
	 */
    private static final Log LOG = LogFactory.getLog(PortletContextImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    protected final PortletApplicationDefinition portletApp;
    protected final ServletContext servletContext;
    protected ClassLoader contextClassLoader;

    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param servletContext  the servlet context in which we are contained.
     * @param portletAppDD  the portlet application descriptor.
     */
    public PortletContextImpl(ServletContext servletContext,
                              PortletApplicationDefinition portletApp) {
        this.servletContext = servletContext;
        this.portletApp = portletApp;
        init();
    }
    
    private void init() {
        setContextClassLoader(Thread.currentThread().getContextClassLoader());
    }
    
    public String getApplicationName() {
        return portletApp.getName();
    }
    
    /**
     * ClassLoader associated with this context.
     * @return
     */
    public ClassLoader getContextClassLoader() {
        return contextClassLoader;
    }

    /**
     * ClassLoader associated with this context.
     * @param contextClassLoader
     */
    public void setContextClassLoader(ClassLoader contextClassLoader) {
        this.contextClassLoader = contextClassLoader;
    }

    public String getContextPath() {
        return portletApp.getContextPath();
    }
    
    // PortletContext Impl -----------------------------------------------------
    
    /**
     * Retrieve the PortletContainer's server info.
     * @return the server info in the form of <i>Server/Version</i>
     * @see Environment#getServerInfo()
     */
    public String getServerInfo() {
        return Configuration.getServerInfo();
    }
    
    public PortletRequestDispatcher getRequestDispatcher(String path)
    {
        if (LOG.isDebugEnabled()) {
            LOG.debug("PortletRequestDispatcher requested: " + path);
        }
        
        // Check if the path name is valid. A valid path name must not be null
        //   and must start with a slash '/' as defined by the portlet spec.
        if (path == null || !path.startsWith("/")) {
        	if (LOG.isInfoEnabled()) {
        		LOG.info("Failed to retrieve PortletRequestDispatcher: "
        				+ "path name must begin with a slash '/'.");
        	}
        	return null;
        }
        
        // Construct PortletRequestDispatcher.
        PortletRequestDispatcher portletRequestDispatcher = null;
        try {
            RequestDispatcher servletRequestDispatcher = servletContext.getRequestDispatcher(path);
            if (servletRequestDispatcher != null) {

                RequestDispatcherPathInfoProvider provider = RequestDispatcherPathInfoProviderImpl.getProvider(this, portletApp);
            	portletRequestDispatcher = new PortletRequestDispatcherImpl(servletRequestDispatcher, provider.getPathInfo(getContextPath(), path));
            } else {
            	if (LOG.isInfoEnabled()) {
            		LOG.info("No matching request dispatcher found for: " + path);
            	}
            }
        } catch (Exception ex) {
            // We need to catch exception because of a Tomcat 4.x bug.
            //   Tomcat throws an exception instead of return null if the path
        	//   was not found.
        	if (LOG.isInfoEnabled()) {
        		LOG.info("Failed to retrieve PortletRequestDispatcher: "
        				+ ex.getMessage());
        	}
        	portletRequestDispatcher = null;
        }
        return portletRequestDispatcher;
    }
    
    public PortletRequestDispatcher getNamedDispatcher(String name) {
        RequestDispatcher dispatcher = servletContext.getNamedDispatcher(name);
        if (dispatcher != null)
        {
            RequestDispatcherPathInfoProvider provider = RequestDispatcherPathInfoProviderImpl.getProvider(this, portletApp);
            return new PortletRequestDispatcherImpl(dispatcher, provider.getNamedRequestDispatcherPathInfo());
        } else {
        	if (LOG.isInfoEnabled()) {
        		LOG.info("No matching request dispatcher found for name: "
        				+ name);
        	}
        }
        return null;
    }

    public InputStream getResourceAsStream(String path) {
        return servletContext.getResourceAsStream(path);
    }

    public int getMajorVersion() {
        return Configuration.getMajorSpecificationVersion();
    }

    public int getMinorVersion() {
        return Configuration.getMinorSpecificationVersion();
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
    
    
    // org.apache.pluto.core.InternalPortletContext Impl -----------------------
    
    public ServletContext getServletContext() {
        return servletContext;
    }

    public PortletApplicationDefinition getPortletApplicationDefinition() {
        return portletApp;
    }

	public Enumeration<String> getContainerRuntimeOptions() {
	    return Collections.enumeration(Configuration.getSupportedContainerRuntimeOptions());
	}
}

