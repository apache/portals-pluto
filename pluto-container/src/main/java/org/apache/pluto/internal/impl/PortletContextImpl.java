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
package org.apache.pluto.internal.impl;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.container.InternalPortletContext;
import org.apache.pluto.container.RequestDispatcherPathInfo;
import org.apache.pluto.container.om.portlet.PortletApplicationDefinition;

/**
 * Pluto's Portlet Context Implementation. This class implements the
 * <code>InternalPortletContext</code> which provides container specific
 * information needed for processing.
 * 
 * @version 1.1
 */
public class PortletContextImpl
implements PortletContext, InternalPortletContext {
	
	/**
	 *  Logger.
	 */
    private static final Log LOG = LogFactory.getLog(PortletContextImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    protected final PortletApplicationDefinition portletApp;
    protected final ServletContext servletContext;
    protected ClassLoader contextClassLoader;

    protected List<String> exactServletMappingURLPatterns;
    protected List<String> pathServletMappingURLPatterns;
    protected List<String> extServletMappingURLPatterns;
    protected boolean defaultServletMapping = false;
    
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
        String path = portletApp.getName();
        if (!path.equals("")) {
            path = "/" + path;
        }
        return path;
    }
    
    // PortletContext Impl -----------------------------------------------------
    
    /**
     * Retrieve the PortletContainer's server info.
     * @return the server info in the form of <i>Server/Version</i>
     * @see Environment#getServerInfo()
     */
    public String getServerInfo() {
        return Environment.getServerInfo();
    }
    
    public RequestDispatcherPathInfo getPathInfo(String path)
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
        
        synchronized (this)
        {
            if (exactServletMappingURLPatterns == null)
            {
                defaultServletMapping = false;
                exactServletMappingURLPatterns = new ArrayList<String>();
                pathServletMappingURLPatterns = new ArrayList<String>();
                extServletMappingURLPatterns = new ArrayList<String>();
                
                for (String pat : portletApp.getServletMappingURLPatterns())
                {                 
                    if (pat.startsWith("/"))
                    {
                        if (pat.equals("/"))
                        {
                            defaultServletMapping = true;
                        }
                        else if (pat.endsWith("/*"))
                        {
                            pathServletMappingURLPatterns.add(pat.substring(0,-2));
                        }
                        else
                        {
                            exactServletMappingURLPatterns.add(pat);
                        }
                    }
                    else if (pat.startsWith("*."))
                    {
                        extServletMappingURLPatterns.add(pat.substring(1));
                    }
                    else
                    {
                        exactServletMappingURLPatterns.add(pat);
                    }
                }
            }
        }
        if (exactServletMappingURLPatterns.contains(path))
        {
            servletPath = path;
            pathInfo = null;
        }
        else if ( path.charAt(0) == '/' && (index = path.lastIndexOf('/')) != -1)
        {
            if (path.length() == 1 && defaultServletMapping)
            {
                servletPath = path;
                pathInfo = null;
            }
            else
            {
                String sub = path;
                do
                {
                    sub = sub.substring(0, index);
                    if (pathServletMappingURLPatterns.contains(sub))
                    {
                        servletPath = sub;
                        pathInfo = path.substring(sub.length()+1);
                        break;
                    }
                    index = sub.lastIndexOf('/');
                }
                while (index != -1);
            }
        }
        if (servletPath == null)
        {
            ;            
            if ((index = path.lastIndexOf('/')) != -1)
            {
                int ext = path.indexOf('.', index);
                if (extServletMappingURLPatterns.contains(path.substring(index)))
                {
                    servletPath = path.substring(0, index);
                    pathInfo = path.substring(index);
                }
            }
        }
        if (servletPath == null)
        {
            servletPath = path;            
        }
        
        return new RequestDispatcherPathInfoImpl(getContextPath(),servletPath,pathInfo,queryString);
    }

    public PortletRequestDispatcher getRequestDispatcher(String path) {
    	
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
            RequestDispatcher servletRequestDispatcher = servletContext
            		.getRequestDispatcher(path);
            if (servletRequestDispatcher != null) {

            	portletRequestDispatcher = new PortletRequestDispatcherImpl(servletRequestDispatcher, getPathInfo(path));
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
        if (dispatcher != null) {
            return new PortletRequestDispatcherImpl(dispatcher);
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
        return Environment.getMajorSpecificationVersion();
    }

    public int getMinorVersion() {
        return Environment.getMinorSpecificationVersion();
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

