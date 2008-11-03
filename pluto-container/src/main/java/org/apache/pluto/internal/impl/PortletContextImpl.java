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
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.internal.InternalPortletContext;
import org.apache.pluto.om.portlet.ContainerRuntimeOption;
import org.apache.pluto.om.portlet.PortletDefinition;
import org.apache.pluto.om.portlet.PortletApplicationDefinition;

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
    
    
    /** Portlet */
    protected PortletDefinition portlet = null;

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

    
    // PortletContext Impl -----------------------------------------------------
    
    /**
     * Retrieve the PortletContainer's server info.
     * @return the server info in the form of <i>Server/Version</i>
     * @see Environment#getServerInfo()
     */
    public String getServerInfo() {
        return Environment.getServerInfo();
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
            	portletRequestDispatcher = new PortletRequestDispatcherImpl(
                		servletRequestDispatcher, path);
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


	public Map<String, String[]> getApplicationRuntimeOptions() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		if (portletApp.getContainerRuntimeOptions() != null){
			for (ContainerRuntimeOption option : portletApp.getContainerRuntimeOptions()) {
				if (getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValues();
					String [] tempValues = new String[values.size()];
					for (int i=0;i<values.size();i++){
						tempValues[i] = values.get(i);
					}
					resultMap.put(option.getName(),tempValues);
				}
			}
		}
		return resultMap;
	}

	public Map<String, String[]> getPortletRuntimeOptions() {
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		if (portlet.getContainerRuntimeOptions() != null) {
			for (ContainerRuntimeOption option : portlet.getContainerRuntimeOptions()) {
				if (this.getSupportedContainerRuntimeOptions().contains(option.getName())){
					List<String> values = option.getValues();
					String [] tempValues = new String[values.size()];
					for (int i=0;i<values.size();i++){
						tempValues[i] = values.get(i);
					}
					resultMap.put(option.getName(),tempValues);
				}
			}
		}
		return resultMap;
	}


	public Enumeration<String> getContainerRuntimeOptions() {
		Map<String,String[]> appRuntimeOptions = getApplicationRuntimeOptions();
		Map<String,String[]> portletRuntimeOptions = getPortletRuntimeOptions();
		
		// merge these two, with portlet priority
		Map<String, String[]> resultMap = new HashMap<String, String[]>();
		
		// first all entries in portletAppDD (without these in portletDD)
		for (String option : appRuntimeOptions.keySet()) {
			if (portletRuntimeOptions.containsKey(option))
				resultMap.put(option, portletRuntimeOptions.get(option));
			else
				resultMap.put(option, appRuntimeOptions.get(option));
		}
		// and now the rest
		if (portletRuntimeOptions != null){
			for (String option : portletRuntimeOptions.keySet()) {
				if (!appRuntimeOptions.containsKey(option))
					resultMap.put(option, portletRuntimeOptions.get(option));
			}
		}
		//return resultMap;
		return null;
	}
	
	protected List<String> getSupportedContainerRuntimeOptions()
	{
	    return Configuration.getSupportedContainerRuntimeOptions();
	}
}

