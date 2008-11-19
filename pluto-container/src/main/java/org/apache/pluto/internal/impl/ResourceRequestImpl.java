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
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalResourceRequest;
import org.apache.pluto.spi.PortletURLProvider;
import org.apache.pluto.util.ArgumentUtility;
import org.apache.pluto.util.StringUtils;

public class ResourceRequestImpl extends ClientDataRequestImpl
implements ResourceRequest, InternalResourceRequest {

	/** Logger. */
    private static final Log LOG = LogFactory.getLog(ResourceRequestImpl.class);
    
        
    // Constructor -------------------------------------------------------------
    
    public ResourceRequestImpl(PortletContainer container,
                             PortletWindow portletWindow,
                             HttpServletRequest servletRequest) {
        super(container, portletWindow, servletRequest);
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Created action request for: " + portletWindow);
        }
    }

    // ResourceRequest impl ------------------------------------------------------

    protected Integer getRequestMethod()
    {
        return Constants.METHOD_RESOURCE; 
    }
    
    public String getResponseContentType(){
    	return super.getResponseContentType();
    }
    
    @SuppressWarnings("unchecked")
	public java.util.Enumeration getResponseContentTypes(){
    	return super.getResponseContentTypes();
    }
    
    public String[] getParameterValues(String name) {
    	ArgumentUtility.validateNotNull("parameterName", name);
    	String values1[] = super.getParameterValues(name);
    	PortletURLProvider urlProvider = container.getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(getHttpServletRequest(), portletWindow);
    	String values2[] = urlProvider.getPrivateRenderParameters(name);
    	String values[] = null;
    	int length1 = 0;
    	int length2 = 0;
    	if (values1 != null)
    		length1 = values1.length;
    	if (values2 != null){
    		length2 += values2.length;
    		values = new String[length1+length2];
    		System.arraycopy(values2, 0, values, length1, length2);
    	}
    	else if (length1>0){
    		values = new String[length1];
    	}
    	
    	if (length1>0){
    		System.arraycopy(values1, 0, values, 0, length1);
    	}
    	if ((length1+length2) == 0){
    		values = null;
    	}
        if (values != null) {
            values = StringUtils.copy(values);
        }
        return values;
    }
    
    public String getParameter(String name) {
    	
    	ArgumentUtility.validateNotNull("parameterName", name);
    	String value = super.getParameter(name);
    	if (value == null){
    		PortletURLProvider urlProvider = container.getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(getHttpServletRequest(), portletWindow);
        	String[] values1 = urlProvider.getPrivateRenderParameters(name);
        	if (values1!= null){
        		if (values1.length>0){
        			value = values1[0];
        		}
        	}
    	}
		return value;
    }
    
    // PortletRequestImpl impl -------------------------------------------------
    
	public String getETag() {
		// TODO: get ETag
		return null;
	}

	public String getLifecyclePhase() 
	{
		return RESOURCE_PHASE;
	}

	public String getResourceID() {
		return getParameter("resourceID");
	}
	
	public ServletInputStream getInputStream() throws IOException {
        return (super.isIncluded() || super.isForwarded()) ? (ServletInputStream)getPortletInputStream() : super.getInputStream();
    }

	public Map<String, String[]> getPrivateRenderParameterMap() {
		return super.getPrivateParameterMap();
	}

	public String getCacheability() {
		return null;
	}
}
