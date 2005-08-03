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
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Pluto's Portlet Context Implementation.
 * Implements the InternalPortletContext which provides container
 * specific information which is needed for processing.
 *
 * @version 1.1
 * @author <a href="ddewolf@apache.org">David H. DeWolf</a>
 *
 */
public class PortletContextImpl
    implements PortletContext, InternalPortletContext {

    private static final Log LOG =
        LogFactory.getLog(PortletContextImpl.class);

    /** Portlet Application Descriptor. */
    private PortletAppDD portletAppDD;

    /** ServletContext in which we are contained. */
    private ServletContext servletContext;

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

    /**
     * Retrieve the PortletContainer's server info.
     * @return the server info in the form of <i>Server/Version</i>
     * @see Environment#getServerInfo()
     */
    public String getServerInfo() {
        return Environment.getServerInfo();
    }

    public PortletRequestDispatcher getRequestDispatcher(String path) {
        if(LOG.isDebugEnabled()) {
            LOG.debug("Portlet Dispatcher Requested: "+path);
        }
        try {
            Map params = parseQueryParams(path);
            RequestDispatcher rd = servletContext.getRequestDispatcher(path);
            if(rd != null) {
                return new PortletRequestDispatcherImpl(rd, params);
            }
            else if(LOG.isInfoEnabled()) {
                LOG.info("No Matching Request Dispatcher not found.");
            }
        } catch (Exception e) {
            // need to catch exception because of tomcat 4.x bug
            // tomcat throws an exception instead of return null
            // if the path was not found
        }

        return null;
    }

    public PortletRequestDispatcher getNamedDispatcher(String name) {
        RequestDispatcher rd = servletContext.getNamedDispatcher(name);
        if(rd != null) {
            return new PortletRequestDispatcherImpl(rd);
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
    // --------------------------------------------------------------------------------------------

    // org.apache.pluto.core.InternalPortletContext implementation --------------------------------
    public javax.servlet.ServletContext getServletContext() {
        return servletContext;
    }

    public PortletAppDD getPortletApplicationDefinition() {
        return portletAppDD;
    }

    private Map parseQueryParams(String path) {
        Map map = new java.util.HashMap();
        int idx = path.indexOf("?");
        if(idx < 0) {
            return null;
        }
        String parms = path.substring(idx+1);
        StringTokenizer st = new StringTokenizer(parms, "&");
        while(st.hasMoreTokens()) {
            String pair = st.nextToken();
            if(pair.indexOf("=")>0) {
                String key = pair.substring(0,pair.indexOf("="));
                String val = pair.substring(pair.indexOf("=")+1);
                map.put(key, new String[] {val});
            }
        }
        if(LOG.isDebugEnabled()) {
            LOG.debug(map.size() + " additional Query Parameters appended to original request.");
        }
        return map;
    }
}

