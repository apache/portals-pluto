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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Pluto's Portlet Context Implementation.
 * <p>This class implements the <code>InternalPortletContext</code> which
 * provides container specific information needed for processing.</p>
 * 
 * @version 1.1
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 */
public class PortletContextImpl
implements PortletContext, InternalPortletContext {
	
	/** Internal logger. */
    private static final Log LOG = LogFactory.getLog(PortletContextImpl.class);

    /** Portlet Application Descriptor. */
    private PortletAppDD portletAppDD = null;

    /** ServletContext in which we are contained. */
    private ServletContext servletContext = null;

    
    // Constructor -------------------------------------------------------------
    
    /**
     * Sole constructor.
     *
     * @param servletContext the servlet context in which we are contained.
     * @param portletAppDD the application descriptor.
     */
    public PortletContextImpl(ServletContext servletContext,
                              PortletAppDD portletAppDD) {
        this.servletContext = servletContext;
        this.portletAppDD = portletAppDD;
    }
    
    
    // javax.portlet.PortletContext Impl ---------------------------------------
    
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
            LOG.debug("Portlet Dispatcher Requested: " + path);
        }
        try {
            Map params = parseQueryParams(path);
            RequestDispatcher dispatcher = servletContext
            		.getRequestDispatcher(path);
            if (dispatcher != null) {
                return new PortletRequestDispatcherImpl(dispatcher, params);
            } else {
            	if (LOG.isInfoEnabled()) {
            		LOG.info("No matching request dispatcher found for path: "
            				+ path);
            	}
            }
        } catch (Exception ex) {
            // need to catch exception because of tomcat 4.x bug
            // tomcat throws an exception instead of return null
            // if the path was not found
        }
        return null;
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
     * Parse the query path and extract appended parameters. This method puts
     * parameters into a map. The key is the parameter name as a string; the
     * value is a string array holding parameter values.
     * 
     * @param path the query path to parse.
     * @return parameter map, or null if no parameters are appended.
     */
    private Map parseQueryParams(String path) {
    	int index = path.indexOf("?");
    	if (index < 0 || index == path.length() - 1) {
    		return null;
    	}
        Map params = new HashMap();
        String paramsString = path.substring(index + 1);
        StringTokenizer st = new StringTokenizer(paramsString, "&", false);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            int equalIndex = token.indexOf("=");
            if (equalIndex > 0 && equalIndex < token.length() - 1) {
                String key = token.substring(0, equalIndex);
                String value = token.substring(equalIndex + 1);
                String[] values = (String[]) params.get(key);
                if (values == null) {
                	values = new String[] { value };
                } else {
                	List valueList = Arrays.asList(values);
                	valueList.add(value);
                	values = (String[]) valueList.toArray(
                			new String[valueList.size()]);
                }
            	params.put(key, values);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug(params.size() + " additional Query Parameters appended to original request.");
        }
        return params;
    }
    
}

