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
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.EventRequest;
import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.StateAwareResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.xml.XMLConstants;
import javax.xml.namespace.QName;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.EventProvider;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.spi.ResourceURLProvider;
import org.apache.pluto.util.DummyPrintWriter;
import org.apache.pluto.util.DummyServletOutputStream;
import org.apache.pluto.util.StringUtils;

/**
 * Implementation of JSR-286 <code>StateAwareResponse</code>.
 *
 * @since 2.0
 */
public class StateAwareResponseImpl extends PortletResponseImpl implements
		StateAwareResponse {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(StateAwareResponseImpl.class);

	boolean redirectAllowed = true;
	protected boolean redirected;
	private String redirectLocation;
    

	private Map<String, String[]> publicRenderParameter = new HashMap<String, String[]>();
	
    private Map<String, String[]> renderParameters = new HashMap<String, String[]>();
    private WindowState windowState = null;
    private PortletMode portletMode = null;
	protected PortalCallbackService callback;
    private PortalContext context;
    private EventRequest eventRequest;
    
	public StateAwareResponseImpl(PortletContainer container,
			            InternalPortletWindow internalPortletWindow,
			            HttpServletRequest servletRequest,
			            HttpServletResponse servletResponse) {
		super(container, internalPortletWindow, servletRequest,
		servletResponse);
		context = container.getRequiredContainerServices().getPortalContext();
		callback = container.getRequiredContainerServices().getPortalCallbackService();
	}
	
	/* (non-Javadoc)
	 * @see javax.portlet.StateAwareResponse#setEvent(javax.xml.namespace.QName, java.lang.Object)
	 */
	public void setEvent(QName qname, Serializable value){
		if (qname == null) {
			throw new IllegalArgumentException();
		}
		
		EventProvider provider = callback.getEventProvider(
				getHttpServletRequest(),getInternalPortletWindow());
 	
		provider.registerToFireEvent(qname, value);
	}

	/* (non-Javadoc)
	 * @see javax.portlet.StateAwareResponse#setEvent(java.lang.String, java.lang.Object)
	 */
	public void setEvent(String name, Serializable value) {
        String contextPath = getInternalPortletWindow().getContextPath();
        String defaultNamespace;
        try {
            defaultNamespace = getContainer().getPortletApplicationDescriptor(contextPath).getDefaultNamespace();
        } catch (PortletContainerException e) { 
            LOG.error(contextPath, e); 
            defaultNamespace = XMLConstants.NULL_NS_URI;
        }
        QName qname = new QName(defaultNamespace, name);
        setEvent(qname, value);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServletResponseWrapper#sendRedirect(java.lang.String)
	 */
	public void sendRedirect(String location) throws java.io.IOException {
        if (redirectAllowed) {
            if (location != null) {
                HttpServletResponse redirectResponse = getHttpServletResponse();
                while (redirectResponse instanceof HttpServletResponseWrapper) {
                    redirectResponse = (HttpServletResponse)
                        ((HttpServletResponseWrapper)redirectResponse).getResponse();
                }

                ResourceURLProvider provider = callback.getResourceURLProvider(
                                getHttpServletRequest(),
                                getInternalPortletWindow()
                );

                if (location.indexOf("://") != -1) {
                    provider.setAbsoluteURL(location);
                } else {
                    provider.setFullPath(location);
                }
                location =
                redirectResponse.encodeRedirectURL(provider.toString());
                if (location.indexOf("/") == -1)
                	throw new IllegalArgumentException("There is a relative path given, an IllegalArgumentException must be thrown.");
                //redirectResponse.sendRedirect(location);
                redirectLocation = location;
                redirected = true;
            }
        } else {
            throw new java.lang.IllegalStateException(
                "Can't invoke sendRedirect() after certain methods have been called");
        }
    }

    

    public String getRedirectLocation() {
        return redirectLocation;
    }
	//
//	 javax.portlet.ActionResponse
	//
    public void setWindowState(WindowState windowState)
        throws WindowStateException {
        if (redirected) {
            throw new IllegalStateException(
                "it is not allowed to invoke setWindowState after sendRedirect has been called");
        }

        if (isWindowStateAllowed(windowState)) {
            this.windowState = windowState;
        } else {
            throw new WindowStateException("Can't set this WindowState",
                                           windowState);
        }
        redirectAllowed = false;
    }
	    
    public void setPortletMode(PortletMode portletMode)
        throws PortletModeException {
        if (redirected) {
            throw new IllegalStateException(
                "it is not allowed to invoke setPortletMode after sendRedirect has been called");
        }

        // check if portal supports portlet mode
        boolean supported = isPortletModeAllowed(portletMode);


        // if porlet mode is allowed
        if (supported) {
            this.portletMode = portletMode;
        } else {
            throw new PortletModeException("Can't set this PortletMode",
                                           portletMode);
        }

        redirectAllowed = false;

    }
    
    public void setRenderParameters(java.util.Map<String, String[]> parameters) {
        if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameters() after sendRedirect() has been called");
        }
        if (parameters == null) {
            throw new IllegalArgumentException(
                "Render parameters must not be null.");
        }
        for (Iterator iter = parameters.entrySet().iterator(); iter.hasNext();) {
            Map.Entry entry = (Map.Entry) iter.next();
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException(
                    "Key must not be null and of type java.lang.String.");
            }
            if (!(entry.getValue() instanceof String[])) {
                throw new IllegalArgumentException(
                    "Value must not be null and of type java.lang.String[].");
            }
        }
        
        renderParameters.clear();
        publicRenderParameter.clear();
        if (parameters.keySet()!= null){
        	for (Object key : parameters.keySet()) {
        		this.setRenderParameter((String)key, (String[])parameters.get(key));
    		}
        }
        
        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String value) {
        if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameter() after sendRedirect() has been called");
        }

        if ((key == null || value == null)) {
            throw new IllegalArgumentException(
                "Render parameter key must not be null.");
        }
        List<String> publicRenderParameterNames = super.getInternalPortletWindow().getPortletEntity().getPortletDefinition().getPublicRenderParameter();
        if (publicRenderParameterNames != null){
	    	if (publicRenderParameterNames.contains(key)){
	        	publicRenderParameter.put(key, new String[] {value});
	        }
	        else{
	        	renderParameters.put(key, new String[]{value});
	        }
        }
        else{
        	renderParameters.put(key, new String[]{value});
        }
        redirectAllowed = false;
    }
    
    public void setRenderParameter(String key, String[] values) {
    	if (redirected) {
            throw new IllegalStateException(
                "Can't invoke setRenderParameter() after sendRedirect() has been called");
        }        
        
        if (key == null || values == null) {
	        throw new IllegalArgumentException(
	        	"name and values must not be null or values be an empty array");
	    }
	    List<String> publicRenderParameterNames = super.getInternalPortletWindow().getPortletEntity().getPortletDefinition().getPublicRenderParameter();
	    if (publicRenderParameterNames != null){
		    if (publicRenderParameterNames.contains(key)){
		    	publicRenderParameter.put(key,StringUtils.copy(values));
		    }
		    else{
		    	renderParameters.put(key, StringUtils.copy(values));
		    }
	    }
	    else{
	    	renderParameters.put(key, StringUtils.copy(values));
	    }
    }
    // --------------------------------------------------------------------------------------------
    
    // org.apache.pluto.core.InternalActionResponse implementation --------------------------------
    public Map getRenderParameters() {
        return renderParameters;
    }
    
    public Map<String, String[]> getRenderParameterMap() {
		return renderParameters;
	}
    
    public Map<String, String[]> getPublicRenderParameter(){
    	return publicRenderParameter;
    }

    public PortletMode getChangedPortletMode() {
        return this.portletMode;
    }
    
    public PortletMode getPortletMode() {
		return getChangedPortletMode();
	}

    public WindowState getChangedWindowState() {
        return this.windowState;
    }
    
    public WindowState getWindowState() {
		return getChangedWindowState();
	}
    
    protected boolean isPortletModeAllowed(PortletMode mode) {
        return isPortletModeAllowedByPortlet(mode)
               && isPortletModeAllowedByPortal(mode);
    }

    protected boolean isPortletModeAllowedByPortlet(PortletMode mode) {
        PortletDD dd = getInternalPortletWindow().getPortletEntity()
            .getPortletDefinition();

        Iterator supports = dd.getSupports().iterator();
        while(supports.hasNext()) {
            SupportsDD sup = (SupportsDD)supports.next();
            List<String> portletModes = sup.getPortletModes();
            if (portletModes == null)
            	return false;
            Iterator modes = portletModes.iterator();
            while(modes.hasNext()) {
                if (modes.next().toString().equalsIgnoreCase(mode.toString())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected boolean isPortletModeAllowedByPortal(PortletMode mode) {
        Enumeration supportedModes = context.getSupportedPortletModes();
        while (supportedModes.hasMoreElements()) {
            if (supportedModes.nextElement().toString().equalsIgnoreCase(
                (mode.toString()))) {
                return true;
            }
        }
        return false;
    }

    protected boolean isWindowStateAllowed(WindowState state) {
        Enumeration supportedStates = context.getSupportedWindowStates();
        while (supportedStates.hasMoreElements()) {
            if (supportedStates.nextElement().toString().equalsIgnoreCase(
                (state.toString()))) {
                return true;
            }
        }
        return false;
    }
	
	//	 access to a limited set of HttpServletResponse methods ------------------
	
	@Override
	public void reset() {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.reset();
	}

	@Override
	public void resetBuffer() {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.resetBuffer();
	}

	@Override
	public void setBufferSize(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setBufferSize(arg0);
	}

	@Override
	public void setCharacterEncoding(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setCharacterEncoding(arg0);
	}

	@Override
	public void setContentLength(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setContentLength(arg0);
	}

	@Override
	public void setContentType(String arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setContentType(arg0);
	}

	@Override
	public void setLocale(Locale arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setLocale(arg0);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IllegalStateException, IOException {
		if (super.isForwarded() || super.isIncluded()){
			return new DummyServletOutputStream();
		}
		else
			return super.getOutputStream();
	}

	@Override
	public PrintWriter getWriter() throws IllegalStateException, IOException {
		if (super.isForwarded() || super.isIncluded()){
			return new DummyPrintWriter(super.getWriter());
		}
		else
			return super.getWriter();
	}

	@Override
	public void addDateHeader(String arg0, long arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addDateHeader(arg0, arg1);
	}

	@Override
	public void addHeader(String arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addHeader(arg0, arg1);
	}

	@Override
	public void addIntHeader(String arg0, int arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.addIntHeader(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setStatus(arg0, arg1);
	}

	@Override
	public void setDateHeader(String arg0, long arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setDateHeader(arg0, arg1);
	}

	@Override
	public void setHeader(String arg0, String arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setHeader(arg0, arg1);
	}

	@Override
	public void setIntHeader(String arg0, int arg1) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setIntHeader(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0) {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.setStatus(arg0);
	}

	@Override
	public void flushBuffer() throws IOException {
		if (super.isForwarded() || super.isIncluded()){
			// no operation
		}
		else
			super.flushBuffer();
	}

	/*
	 * The pluto implementation don't works with buffering.
	 * @see javax.servlet.ServletResponseWrapper#getBufferSize()
	 */
	@Override
	public int getBufferSize() {
		if (super.isForwarded() || super.isIncluded()){
			return 0;
		}
		else
			return 0;
	}

	@Override
	public String getCharacterEncoding() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getCharacterEncoding();
	}

	@Override
	public String getContentType() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getContentType();
	}

	@Override
	public Locale getLocale() {
		if (super.isForwarded() || super.isIncluded()){
			return null;
		}
		else
			return super.getLocale();
	}

	@Override
	public boolean isCommitted() {
		if (super.isForwarded()){
			return false;
		}
		else if (super.isIncluded()){
			return true;
		}
		else
			return super.isCommitted();
	}

	public void removePublicRenderParameter(String name) {
		List<String> publicRenderParameterNames = super.getInternalPortletWindow().getPortletEntity().getPortletDefinition().getPublicRenderParameter();
		if (publicRenderParameterNames != null){
			if (publicRenderParameterNames.contains(name)){
	    		publicRenderParameter.put(name,new String[] {null});
		    }
	    	else{
	    		throw new IllegalArgumentException(
	    			"name and values must not be null or values be an empty array");
	    	}
		}
	}

	public void setEventRequest(EventRequest eventRequest) {
		this.eventRequest = eventRequest;
	}
	
}
