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
import javax.portlet.PortletURL;
import javax.portlet.ResourceURL;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalPortletResponse;
import org.apache.pluto.spi.ResourceURLProvider;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.DummyPrintWriter;
import org.apache.pluto.util.NamespaceMapper;
import org.apache.pluto.util.PrintWriterServletOutputStream;
import org.apache.pluto.util.impl.NamespaceMapperImpl;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Abstract <code>javax.portlet.PortletResponse</code> implementation.
 * This class also implements InternalPortletResponse.
 *
 */
public abstract class PortletResponseImpl extends HttpServletResponseWrapper
implements PortletResponse, InternalPortletResponse {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(PortletResponseImpl.class);
	// Private Member Variables ------------------------------------------------
	
	/** The portlet container. */
    private PortletContainer container;
    
    /** The portlet window. */
    private PortletWindow portletWindow;

    /** The servlet request of the target/portlet's web module. */
    private HttpServletRequest httpServletRequest;
    
    private boolean usingWriter;
    private boolean usingStream;

    private ServletOutputStream wrappedWriter;
    
    private NamespaceMapper mapper = new NamespaceMapperImpl();
    
    /** True if we are in an include call. */
    private boolean included = false;
    
    /** True if we are in an forwarded call. */
    private boolean forwarded = false;
    
    private boolean requestForwarded = false;
    
    // Constructor -------------------------------------------------------------
    
    public PortletResponseImpl(PortletContainer container,
                               PortletWindow portletWindow,
                               HttpServletRequest servletRequest,
                               HttpServletResponse servletResponse) {
        super(servletResponse);
        this.container = container;
        this.httpServletRequest = servletRequest;
        this.portletWindow = portletWindow;
    }
    
    
    // PortletResponse Impl ----------------------------------------------------
    
    public void addProperty(String name, String value) {
    	ArgumentUtility.validateNotNull("propertyName", name);
        container.getRequiredContainerServices()
        		.getPortalCallbackService()
        		.addResponseProperty(
        				getHttpServletRequest(),
        				portletWindow,
        				name, value);
    }
    
    public void addProperty(String name, String value, int scope) {
    	// FIXME: What should this do? (scope seems to be new)
    	ArgumentUtility.validateNotNull("propertyName", name);
        container.getRequiredContainerServices()
        		.getPortalCallbackService()
        		.addResponseProperty(
        				getHttpServletRequest(),
        				portletWindow,
        				name, value);
    }
    
    public void addProperty(String key, Element element) {
    	container.getRequiredContainerServices().getPortalCallbackService().addResponseProperty(getHttpServletRequest(), portletWindow, key, element);
	}


	public void addProperty(Cookie cookie) {
		container.getRequiredContainerServices().getPortalCallbackService().addResponseProperty(getHttpServletRequest(), portletWindow, cookie);
	}

    public void setProperty(String name, String value) {
    	ArgumentUtility.validateNotNull("propertyName", name);
        container.getRequiredContainerServices()
                .getPortalCallbackService()
                .setResponseProperty(
                        getHttpServletRequest(),
                        portletWindow,
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
        				portletWindow);
        if (path.indexOf("://") != -1) {
            provider.setAbsoluteURL(path);
        } else {
            provider.setFullPath(path);
        }
        return getHttpServletResponse().encodeURL(provider.toString());
    }
    
    
    // InternalPortletResponse impl --------------------------------------------
    
    public PortletWindow getPortletWindow() {
        return portletWindow;
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
        if (isRequestForwarded()&& !isForwarded() && !isIncluded()){
			return new DummyPrintWriter(super.getWriter());
		}
        return getHttpServletResponse().getWriter();
    }

    public PortletURL createRenderURL() {
	    return createURL(false,false);
	}


	public PortletURL createActionURL() {
	    return createURL(true,false);
	}
	
	public ResourceURL createResourceURL(){
		return new ResourceURLImpl(getContainer(),
	                              getPortletWindow(),
	                              getHttpServletRequest(),
	                              getHttpServletResponse());
	}
	
	public ResourceURL createResourceURL(boolean markupContainsPortletURLs){
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	/**
	 * Creates a portlet URL.
	 * TODO: make dynamic? as service?
	 * @param isAction  true for an action URL, false for a render URL.
	 * @return the created portlet (action/render) URL.
	 */
	private PortletURL createURL(boolean isAction, boolean isResourceServing) {
	    return new PortletURLImpl(getContainer(),
	                              getPortletWindow(),
	                              getHttpServletRequest(),
	                              getHttpServletResponse(),
	                              isAction);
	}


	public String getNamespace() {
	     String namespace = mapper.encode(getPortletWindow().getId(), "");
	     StringBuffer validNamespace = new StringBuffer();
	     for (int i = 0; i < namespace.length(); i++) {
	     	char ch = namespace.charAt(i);
	     	if (Character.isJavaIdentifierPart(ch)) {
	     		validNamespace.append(ch);
	     	} else {
	     		validNamespace.append('_');
	     	}
	     }
	     return validNamespace.toString();
	}
	
    @Override
	public void addCookie(Cookie arg0) {
		if (isIncluded()){
			//no operation
		}
		else if (isForwarded()){
			addProperty(arg0);
		}
		else
			super.addCookie(arg0);
	}
	
    @Override
	public boolean containsHeader(String arg0) {
		if (isForwarded() || isIncluded()){
			return false;
		}
		else
			return super.containsHeader(arg0);
	}
	
	@Override
	public String encodeRedirectUrl(String arg0) {
		if (isForwarded() || isIncluded()){
			return null;
		}
		else
		return super.encodeRedirectUrl(arg0);
	}

	@Override
	public String encodeRedirectURL(String arg0) {
		if (isForwarded() || isIncluded()){
			return null;
		}
		else
			return super.encodeRedirectURL(arg0);
	}
	
	@Override
	public void sendError(int arg0) throws IOException {
		if (isForwarded() || isIncluded()){
			// no operation
		}
		else
			super.sendError(arg0);
	}
	
	

	@Override
	public void sendError(int arg0, String arg1) throws IOException {
		if (isForwarded() || isIncluded()){
			// no operation
		}
		else
			super.sendError(arg0, arg1);
	}
	
	public Element createElement(String tagName) throws DOMException {
        DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
		try {
			docBuilder = dbfac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			return doc.createElement(tagName);
		} catch (ParserConfigurationException e) {
            LOG.warn(e);
		}
		throw new DOMException((short) 0, "Initialization fail");
	}
// InternalRenderResponse Impl ---------------------------------------------

	public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }
    
    public boolean isForwarded() {
		return forwarded;
	}


	public void setForwarded(boolean forwared) {
		this.forwarded = forwared;
		
	}

	public boolean isForwardedAllowed(){
		if (usingWriter || usingStream)
			return false;
		else
			return true;
	}


	public boolean isRequestForwarded() {
		return requestForwarded;
	}


	public void setRequestForwarded() {
		requestForwarded = true;
	}
	
	
}
