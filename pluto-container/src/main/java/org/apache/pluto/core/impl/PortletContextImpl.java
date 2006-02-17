/*
 * Copyright 2003,2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/* 

 */

package org.apache.pluto.core.impl;

import org.apache.pluto.core.InternalPortletContext;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Pluto's Portlet Context Implementation. This class implements the
 * <code>InternalPortletContext</code> which provides container specific
 * information needed for processing.
 * 
 * @version 1.1
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class PortletContextImpl
implements PortletContext, InternalPortletContext {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletContextImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    /** Portlet Application Descriptor. */
    private PortletAppDD portletAppDD = null;

    /** ServletContext in which we are contained. */
    private ServletContext servletContext = null;

    
    // Constructor -------------------------------------------------------------
    
    /**
     * Constructs an instance.
     * @param servletContext  the servlet context in which we are contained.
     * @param portletAppDD  the portlet application descriptor.
     */
    public PortletContextImpl(ServletContext servletContext,
                              PortletAppDD portletAppDD) {
        this.servletContext = servletContext;
        this.portletAppDD = portletAppDD;
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
        
        // Extract query string which contains appended parameters.
        Map appendedParameters = null;
        int index = path.indexOf("?");
        if (index > 0 && index < path.length() - 1) {
        	appendedParameters = parseQueryString(path.substring(index + 1));
        }
        
        // Construct PortletRequestDispatcher.
        PortletRequestDispatcher portletRequestDispatcher = null;
        try {
            RequestDispatcher servletRequestDispatcher = servletContext
            		.getRequestDispatcher(path);
            if (servletRequestDispatcher != null) {
            	portletRequestDispatcher = new PortletRequestDispatcherImpl(
                		servletRequestDispatcher, appendedParameters);
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

    public java.util.Set getResourcePaths(String path) {
        return servletContext.getResourcePaths(path);
    }

    public java.net.URL getResource(String path)
        throws java.net.MalformedURLException {
        if (path == null || !path.startsWith("/")) {
            throw new MalformedURLException("path must start with a '/'");
        }
        return servletContext.getResource(path);
    }

    public java.lang.Object getAttribute(java.lang.String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        return servletContext.getAttribute(name);
    }

    public java.util.Enumeration getAttributeNames() {
        return servletContext.getAttributeNames();
    }

    public java.lang.String getInitParameter(java.lang.String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name == null");
        }

        return servletContext.getInitParameter(name);
    }

    public java.util.Enumeration getInitParameterNames() {
        return servletContext.getInitParameterNames();
    }

    public void log(java.lang.String msg) {
        servletContext.log(msg);
    }

    public void log(java.lang.String message, java.lang.Throwable throwable) {
        servletContext.log(message, throwable);
    }

    public void removeAttribute(java.lang.String name) {
        if (name == null) {
            throw new IllegalArgumentException("Attribute name == null");
        }

        servletContext.removeAttribute(name);
    }

    public void setAttribute(java.lang.String name, java.lang.Object object) {
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

    public PortletAppDD getPortletApplicationDefinition() {
        return portletAppDD;
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Parse the query path and extract appended parameters. Query parameters
     * are name-value pairs separated by the character '&'. This method puts
     * parameters into a map. The key is the parameter name as a string; the
     * value is a string array holding parameter values.
     * 
     * @param paramsString  the string containing parameters.
     * @return parameter map, or null if no parameters are appended.
     */
    private Map parseQueryString(String queryString) {
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Parsing query string: " + queryString);
    	}
        Map params = new HashMap();
        StringTokenizer st = new StringTokenizer(queryString, "&", false);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int equalIndex = token.indexOf("=");
            if (equalIndex > 0) {
                String key = token.substring(0, equalIndex);
                String value = null;
                if (equalIndex < token.length() - 1) {
                	value = token.substring(equalIndex + 1);
                } else {
                	value = "";
                }
                String[] values = (String[]) params.get(key);
                if (values == null) {
                	values = new String[] { value };
                } else {
                	// Create a new list to avoid UnsupportedOperationException:
                	// List returned by Arrays.asList() doesn't support add().
            		List valueList = new ArrayList();
            		valueList.addAll(Arrays.asList(values));
            		valueList.add(value);
            		values = (String[]) valueList.toArray(
            				new String[valueList.size()]);
                }
            	params.put(key, values);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(params.size() + " additional query parameters "
            		+ "appended to original request.");
        }
        return params;
    }
    
}

