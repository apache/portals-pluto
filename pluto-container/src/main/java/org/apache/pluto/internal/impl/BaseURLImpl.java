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
import java.io.Writer;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.portlet.BaseURL;
import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.WindowState;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.spi.PublicRenderParameterProvider;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.util.StringUtils;

/**
 * Implementation of JSR-286 <code>BaseURL</code>, which includes a refactoring
 * of <code>PortletURLImpl</code>.
 *
 * @since 2.0
 */
public class BaseURLImpl implements BaseURL {

	private static final StringManager EXCEPTIONS = StringManager.getManager(PortletURLImpl.class.getPackage().getName());
	protected Map parameters = new HashMap();
	protected Map<String, String[]> publicRenderParameters = new HashMap<String, String[]>();
	protected boolean secure;
	protected PortletContainer container;
	protected PortletMode mode = null;
	protected InternalPortletWindow internalPortletWindow;
	protected javax.servlet.http.HttpServletRequest servletRequest;
	protected javax.servlet.http.HttpServletResponse servletResponse;
	protected WindowState state;
	protected boolean isAction;
	protected boolean isResourceServing;
	protected PortalContext context;
	
	public BaseURLImpl(PortletContainer container,
			InternalPortletWindow internalPortletWindow,
			javax.servlet.http.HttpServletRequest servletRequest,
			javax.servlet.http.HttpServletResponse servletResponse,
			boolean isAction, boolean isResourceServing) {
		this.container = container;
		this.internalPortletWindow = internalPortletWindow;
		this.servletRequest = servletRequest;
		this.servletResponse = servletResponse;
		secure = servletRequest.isSecure();
		this.isAction = isAction;
		this.isResourceServing = isResourceServing;
		this.context = container.getRequiredContainerServices().getPortalContext();
	}

	public void setParameter(String name, String value) {
	    if (name == null) {
	        throw new IllegalArgumentException(
	            "name and value must not be null");
	    }
	    PublicRenderParameterProvider provider = container.getRequiredContainerServices().getPortalCallbackService().getPublicRenderParameterProvider();
	    if (value == null){
	    	if (provider.isPublicRenderParameter(internalPortletWindow.getId().getStringId(), name)){
	    		publicRenderParameters.put(name,new String[] {null});
		    	
		    }
	    	else{
	    		throw new IllegalArgumentException(
	            	"name and value must not be null");
	    	}
	    }
	    
	    if (provider.isPublicRenderParameter(internalPortletWindow.getId().getStringId(), name)){
	    	publicRenderParameters.put(name,new String[] {value});
	    }
	    else{
	    	parameters.put(name, new String[]{value});
	    }
	}

	public void setParameter(String name, String[] values) {
		if (name == null) {
	        throw new IllegalArgumentException(
	        	"name and values must not be null or values be an empty array");
	    }
	    PublicRenderParameterProvider provider = container.getRequiredContainerServices().getPortalCallbackService().getPublicRenderParameterProvider();
	    if (values == null){
	    	if (provider.isPublicRenderParameter(internalPortletWindow.getId().getStringId(), name)){
	    		publicRenderParameters.put(name,new String[] {null});
		    }
	    	else{
	    		throw new IllegalArgumentException(
	    			"name and values must not be null or values be an empty array");
	    	}
	    }
	    
	    if (provider.isPublicRenderParameter(internalPortletWindow.getId().getStringId(), name)){
	    	publicRenderParameters.put(name,StringUtils.copy(values));
	    }
	    else{
	    	parameters.put(name, StringUtils.copy(values));
	    }
	}

	public void setParameters(Map parameters) {
		
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
        
        this.parameters.clear();
        this.publicRenderParameters.clear();
        if (parameters.keySet()!= null){
        	for (Object key : parameters.keySet()) {
        		this.setParameter((String)key, (String[])parameters.get(key));
    		}
        }
        
        
	}

	public void setSecure(boolean secure) throws PortletSecurityException {
	    this.secure = secure;
	}

	public String toString() {
	    StringBuffer url = new StringBuffer(200);
	
	    PortletURLProvider urlProvider = container
	    		.getRequiredContainerServices()
	    		.getPortalCallbackService()
	    		.getPortletURLProvider(servletRequest, internalPortletWindow);
	
	    if (mode != null) {
	        urlProvider.setPortletMode(mode);
	    }
	    if (state != null) {
	        urlProvider.setWindowState(state);
	    }
	    if (isAction) {
	        urlProvider.setAction(true);
	    }
	    if (isResourceServing){
	    	urlProvider.setResourceServing(true);
	    }
	    if (secure) {
	        urlProvider.setSecure();
	    }
	    urlProvider.clearParameters();
	    
	    urlProvider.setParameters(parameters);
	    
	    urlProvider.setPublicRenderParameters(publicRenderParameters);
	    
	    url.append(urlProvider.toString());
	
	    return url.toString();
	}
	// --------------------------------------------------------------------------------------------

	public String getParameter(String name) {
	    return (String) parameters.get(name);
	}

	public String[] getParameters(String name) {
	    return (String[]) parameters.get(name);
	}
	
	public Map getParameterMap() {
		return parameters;
	}

	public PortletMode getPortletMode() {
	    return mode;
	}

	public WindowState getWindowState() {
	    return state;
	}
	// --------------------------------------------------------------------------------------------

	protected boolean isPortletModeAllowed(PortletMode mode) throws PortletModeException {
	    if (mode == null) {
	        throw new PortletModeException(
	            EXCEPTIONS.getString("javax.portlet.PortletModeException.null"),
	            null);
	    }
	
	    return isPortletModeAllowedByPortlet(mode)
	           && isPortletModeAllowedByPortal(mode);
	}

	private boolean isPortletModeAllowedByPortlet(PortletMode mode) throws PortletModeException {
	    // PLT 8.1: View Portlet Mode should always be
	    // supported by a portlet, even if not defined in the descriptor
	    if (mode.equals(PortletMode.VIEW)) {
	        return true;
	    }
	
	    PortletDD dd = internalPortletWindow.getPortletEntity()
	        .getPortletDefinition();
	    Iterator supports = dd.getSupports().iterator();
	    while(supports.hasNext()) {
	        SupportsDD support = (SupportsDD)supports.next();
	        Iterator modes = support.getPortletModes().iterator();
	        while(modes.hasNext()) {
	            String md = (String)modes.next();
	            if (md.toUpperCase().equals(
	                mode.toString().toUpperCase())) {
	                return true;
	            }
	        }
	    }
	    String message = EXCEPTIONS.getString(
	        "javax.portlet.PortletModeException.portlet", mode.toString());
	
	    throw new PortletModeException(message, mode);
	}

	private boolean isPortletModeAllowedByPortal(PortletMode mode) throws PortletModeException {
	    Enumeration supportedModes = context.getSupportedPortletModes();
	    while (supportedModes.hasMoreElements()) {
	        if (supportedModes.nextElement().toString().toUpperCase().equals(
	            (mode.toString().toUpperCase()))) {
	            return true;
	        }
	    }
	    String message = EXCEPTIONS.getString(
	        "javax.portlet.PortletModeException.portal", mode.toString());
	
	    throw new PortletModeException(message, mode);
	}

	protected boolean isWindowStateAllowed(WindowState state) {
	    Enumeration supportedStates = context.getSupportedWindowStates();
	    while (supportedStates.hasMoreElements()) {
	        if (supportedStates.nextElement().toString().toUpperCase().equals(
	            (state.toString().toUpperCase()))) {
	            return true;
	        }
	    }
	    return false;
	}

	public void write(Writer out) throws IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}

	public void write(Writer out, boolean escapeXML) throws IOException {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented.");
	}
}
