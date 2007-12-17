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
import java.util.List;
import java.util.Map;

import javax.portlet.BaseURL;
import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletSecurityException;
import javax.portlet.ResourceURL;
import javax.portlet.WindowState;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletContainerException;
import org.apache.pluto.descriptors.portlet.PortletAppDD;
import org.apache.pluto.descriptors.portlet.PortletDD;
import org.apache.pluto.descriptors.portlet.SupportsDD;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.spi.PortletURLListener;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.util.StringManager;
import org.apache.pluto.util.StringUtils;

/**
 * Implementation of JSR-286 <code>BaseURL</code>, which includes a refactoring
 * of <code>PortletURLImpl</code>.
 *
 * @since 2.0
 */
public class BaseURLImpl implements BaseURL {

	private static final Log LOG = LogFactory.getLog(BaseURLImpl.class);
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
		if (!isResourceServing)
			checkCacheLevel();
	}

	private String getCacheability() {
		String cacheLevel[] = getRenderParameters("CACHABILITY");
		if (cacheLevel == null)
			return ResourceURL.PAGE;
		else
			return cacheLevel[0];
	}
	
	private void checkCacheLevel(){
		if (getCacheability().equals(ResourceURL.FULL) || getCacheability().equals(ResourceURL.PORTLET))
			throw new IllegalStateException("Action or RenderURLs have no FULL or PORTLET cache level.");
	}
	
	public void setParameter(String name, String value) {
	    if (name == null || value == null) {
	        throw new IllegalArgumentException(
	            "name and value must not be null");
	    }
	    List<String> publicRenderParameterNames = internalPortletWindow.getPortletEntity().getPortletDefinition().getPublicRenderParameter();
	    if (publicRenderParameterNames == null){
	    	parameters.put(name, new String[]{value});
	    }
	    else{
	    	if (publicRenderParameterNames.contains(name)){
		    	publicRenderParameters.put(name,new String[] {value});
		    }
		    else{
		    	parameters.put(name, new String[]{value});
		    }
		}
	}

	public void setParameter(String name, String[] values) {
		if (name == null || values == null) {
	        throw new IllegalArgumentException(
	        	"name and values must not be null or values be an empty array");
	    }
		List<String> publicRenderParameterNames = internalPortletWindow.getPortletEntity().getPortletDefinition().getPublicRenderParameter();
	    
		if (publicRenderParameterNames == null){
			parameters.put(name, StringUtils.copy(values));
	    }
		else{
			if (publicRenderParameterNames.contains(name)){
		    	publicRenderParameters.put(name,StringUtils.copy(values));
		    }
		    else{
		    	parameters.put(name, StringUtils.copy(values));
		    }
		}
	}

	public void setParameters(Map<String, String[]> parameters) {
		
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
        List<String> publicPortletRenderParameterNames = internalPortletWindow.getPortletEntity().getPortletDefinition().getPublicRenderParameter();
        if (parameters.keySet()!= null){
        	for (Object key : parameters.keySet()) {
        		if (publicPortletRenderParameterNames == null)
        			this.setParameter((String)key, (String[])parameters.get(key));
        		else{
        			//test if this is a public parameter
        			if (publicPortletRenderParameterNames.contains(key))
        				publicRenderParameters.put((String)key, (String[])parameters.get(key));
        			else
        				this.setParameter((String)key, (String[])parameters.get(key));
        		}
    		}
        }
        
        
	}

	public void setSecure(boolean secure) throws PortletSecurityException {
        PortletURLProvider urlProvider = container
        		.getRequiredContainerServices()
        		.getPortalCallbackService()
        		.getPortletURLProvider(servletRequest, internalPortletWindow);
        if(urlProvider.isSecureSupported()) {
            throw new PortletSecurityException("Secure URLs not supported.");
        }
	}

	public String toString(){
	    StringBuffer url = new StringBuffer(200);
	
	    PortletURLProvider urlProvider = container
	    		.getRequiredContainerServices()
	    		.getPortalCallbackService()
	    		.getPortletURLProvider(servletRequest, internalPortletWindow);
	
	    PortletURLListener portletURLFilterListener = portletURLFilterListener = container
			.getRequiredContainerServices()
			.getPortalCallbackService().getPortletURLListener();
	    if (mode != null) {
	        urlProvider.setPortletMode(mode);
	    }
	    if (state != null) {
	        urlProvider.setWindowState(state);
	    }
	    if (isAction) {
	        urlProvider.setAction(true);
	    }
	    else if (isResourceServing){
	    	urlProvider.setResourceServing(true);
	    }
	    try {
	    	
	    	PortletAppDD portletAppDD = container.getPortletApplicationDescriptor(internalPortletWindow.getContextPath());  
//	    	container.getOptionalContainerServices().getPortletRegistryService().getRegisteredPortletApplications()
//			PortletAppDD portletAppDD = container.getPortletApplicationDescriptor(  );
			portletURLFilterListener.callListener(portletAppDD,this,isAction,isResourceServing);
		} catch (PortletContainerException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	    
        if (secure && urlProvider.isSecureSupported()) {
            try {
                urlProvider.setSecure();
            } catch (PortletSecurityException e) {
                throw new IllegalStateException("URL Provider is misconfigured." +
                    "  It claims to support secure urls," +
                    " yet it threw a PortletSecurityException");
            }
	    }
	    if (!isResourceServing)
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
	        if (support.getPortletModes() != null){
	        	Iterator modes = support.getPortletModes().iterator();
		        while(modes.hasNext()) {
		            String md = (String)modes.next();
		            if (md.toUpperCase().equals(
		                mode.toString().toUpperCase())) {
		                return true;
		            }
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

	public void addProperty(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	public void setProperty(String key, String value) {
		// TODO Auto-generated method stub
		
	}

	//TODO:This two methods should be deleted, when the CACHABILITY parameter gets his own prefix
	private String[] getRenderParameters(String name){
		int lenght = 0;
		String[] tmp1 = this.servletRequest.getParameterValues(name);
		if (tmp1!=null)
			lenght += tmp1.length;
		PortletURLProvider urlProvider = container.getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(servletRequest, internalPortletWindow);
		String[] tmp2 = urlProvider.getPrivateRenderParameters(name);
		if (tmp2!=null)
			lenght += tmp2.length;
		String[] tmp3 = urlProvider.getPublicRenderParameters(name);
		if (tmp3!=null)
			lenght += tmp3.length;
		if (lenght>0){
			String[] values = new String[lenght];
			int pos = mergeStrings(tmp1, values, 0);
			pos = mergeStrings(tmp2, values, pos);
			mergeStrings(tmp3, values, pos);
			return values;
		}
		return null;
	}
	private int mergeStrings(String[] src, String[] destination, int position){
		if (src == null)
			return position;
		System.arraycopy(src, 0, destination, position, src.length);
		return position+src.length;
	}
}
