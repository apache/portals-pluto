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

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.ResourceURLProvider;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.PrintWriterServletOutputStream;

/**
 * Abstract <code>javax.portlet.PortletResponse</code> implementation.
 * This class also implements InternalPortletResponse.
 *
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public abstract class PortletResponseImpl extends HttpServletResponseWrapper
implements PortletResponse, InternalPortletResponse {
	
	// Private Member Variables ------------------------------------------------
	
	/** The portlet container. */
    private PortletContainer container = null;
    
    /** The internal portlet window. */
    private InternalPortletWindow internalPortletWindow = null;

    /** The servlet request of the target/portlet's web module. */
    private HttpServletRequest httpServletRequest = null;
    
    private boolean usingWriter;
    private boolean usingStream;

    private ServletOutputStream wrappedWriter;
    
    
    // Constructor -------------------------------------------------------------
    
    public PortletResponseImpl(PortletContainer container,
                               InternalPortletWindow internalPortletWindow,
                               HttpServletRequest servletRequest,
                               HttpServletResponse servletResponse) {
        super(servletResponse);
        this.container = container;
        this.httpServletRequest = servletRequest;
        this.internalPortletWindow = internalPortletWindow;
    }
    
    
    // PortletResponse Impl ----------------------------------------------------
    
    public void addProperty(String name, String value) {
    	ArgumentUtility.validateNotNull("propertyName", name);
        container.getRequiredContainerServices()
        		.getPortalCallbackService()
        		.addResponseProperty(
        				getHttpServletRequest(),
        				internalPortletWindow,
        				name, value);
    }

    public void setProperty(String name, String value) {
    	ArgumentUtility.validateNotNull("propertyName", name);
        container.getRequiredContainerServices()
                .getPortalCallbackService()
                .setResponseProperty(
                        getHttpServletRequest(),
                        internalPortletWindow,
                        name, value);
    }

    public String encodeURL(String path) {
        if (path.indexOf("://") == -1 && !path.startsWith("/")) {
            throw new IllegalArgumentException(
                "only absolute URLs or full path URIs are allowed");
        }
        
        ResourceURLProvider provider = getContainer()
        		.getRequiredContainerServices()
        		.getPortalCallbackService()
        		.getResourceURLProvider(
        				httpServletRequest,
        				internalPortletWindow);
        if (path.indexOf("://") != -1) {
            provider.setAbsoluteURL(path);
        } else {
            provider.setFullPath(path);
        }
        return getHttpServletResponse().encodeURL(provider.toString());
    }
    
    
    // InternalPortletResponse impl --------------------------------------------
    
    public InternalPortletWindow getInternalPortletWindow() {
        return internalPortletWindow;
    }
    
    
    // Internal Methods --------------------------------------------------------
    
    /**
     * Returns the portlet container.
     * @return the portlet container.
     */
    protected PortletContainer getContainer() {
        return container;
    }
    
    /**
     * Returns the nested HttpServletRequest instance.
     * @return the nested HttpServletRequest instance.
     */
    protected HttpServletRequest getHttpServletRequest() {
        return httpServletRequest;
    }
    
    /**
     * Returns the nested HttpServletResponse instance.
     * @return the nested HttpServletResponse instance.
     */
    public HttpServletResponse getHttpServletResponse() {
        return (HttpServletResponse) super.getResponse();
    }
    
    
    // HttpServletResponse Methods ---------------------------------------------
    
    public String encodeUrl(String url) {
        return this.encodeURL(url);
    }
    
    /**
     * TODO: javadoc about why we are using a wrapped writer here.
     * @see org.apache.pluto.util.PrintWriterServletOutputStream
     */
    public ServletOutputStream getOutputStream()
    throws IllegalStateException, IOException {
        if (usingWriter) {
            throw new IllegalStateException(
            		"getPortletOutputStream can't be used "
            		+ "after getWriter was invoked.");
        }
        if (wrappedWriter == null) {
            wrappedWriter = new PrintWriterServletOutputStream(
            		getHttpServletResponse().getWriter());
        }
        usingStream = true;
        return wrappedWriter;
    }
    
    public PrintWriter getWriter()
    throws IllegalStateException, IOException {
        if (usingStream) {
            throw new IllegalStateException(
            		"getWriter can't be used "
            		+ "after getOutputStream was invoked.");
        }
        usingWriter = true;
        return getHttpServletResponse().getWriter();
    }

}
