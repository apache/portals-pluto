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
package org.apache.pluto.internal.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.internal.InternalPortletContext;

import javax.portlet.PortletContext;
import javax.portlet.PortletRequestDispatcher;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * Pluto's Portlet Context Implementation. This class implements the
 * <code>InternalPortletContext</code> which provides container specific
 * information needed for processing.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 * @version 1.1
 */
public class PortletContextImpl
    implements PortletContext, InternalPortletContext {

    /**
     * Logger.
     */
    private static final Log LOG = LogFactory.getLog(PortletContextImpl.class);

    /**
     * Attribute key used to bind the servletContext to the application.
     */
    private static final String CONTEXT_PATH =
        "org.apache.pluto.PORTLET_APP_CONTEXT_PATH";

    /**
     * Servlet 2.5 ServletContext.getContextPath() method.
     */
    private static Method contextPathGetter;

    static {
        try {
            contextPathGetter = ServletContext.class.getMethod("getContextPath", new Class[0]);
        }
        catch (NoSuchMethodException e) {
            LOG.warn("Servlet 2.4 or below detected.  Unable to find getContextPath on ServletContext.");
        }
    }

    // Private Member Variables ------------------------------------------------

    /**
     * Portlet Application Descriptor.
     */
    private PortletAppDD portletAppDD = null;

    /**
     * ServletContext in which we are contained.
     */
    private ServletContext servletContext = null;

    // Constructor -------------------------------------------------------------

    /**
     * Constructs an instance.
     *
     * @param servletContext the servlet context in which we are contained.
     * @param portletAppDD   the portlet application descriptor.
     */
    public PortletContextImpl(ServletContext servletContext,
                              PortletAppDD portletAppDD) {
        this.servletContext = servletContext;
        this.portletAppDD = portletAppDD;
    }

    /**
     * Retrieves the public applicationId published for this context.
     * The algorithm for creating the applicationId is:
     * <li>Attempt to retrieve the contextPath property value from the ServletContext if it exists (Servlet 2.5)</li>
     * <li>Attempt to retrieve the org.apache.pluto.CONTEXT_PATH attribute from the ServletContext</li>
     * <li>If all else fails, use the SerlvetContext.getServletContextName() value</li>
     * <li>Generate a random string</li>
     *
     * @return the published application Id for this context.
     */
    public String getApplicationId() {
        String applicationId =  getContextPath();
        if(applicationId == null) {
            applicationId = servletContext.getServletContextName();
        }

        if(applicationId == null) {
            applicationId = RandomStringUtils.randomAlphanumeric(8);
        }

        return applicationId;
    }

    /**
     * Retrieve the contextPath of the SerlvetContext
     *
     * @return
     */
    public String getContextPath() {
        String contextPath = null;
        if (contextPathGetter != null) {
            try {
                contextPath = (String) contextPathGetter.invoke(servletContext, new Class[0]);
            } catch (Exception e) {
                LOG.warn("Unable to directly retrieve context path from ServletContext.");
            }
        }

        if (contextPath == null) {
            contextPath = (String) servletContext.getAttribute(CONTEXT_PATH);
        }
        
        return contextPath;
    }

    // PortletContext Impl -----------------------------------------------------

    /**
     * Retrieve the PortletContainer's server info.
     *
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
        String queryString = null;
        int index = path.indexOf("?");
        if (index > 0 && index < path.length() - 1) {
            queryString = path.substring(index + 1);
        }

        // Construct PortletRequestDispatcher.
        PortletRequestDispatcher portletRequestDispatcher = null;
        try {
            RequestDispatcher servletRequestDispatcher = servletContext
                .getRequestDispatcher(path);
            if (servletRequestDispatcher != null) {
                portletRequestDispatcher = new PortletRequestDispatcherImpl(
                    servletRequestDispatcher, queryString);
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

}

