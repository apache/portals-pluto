/*
 * Copyright 2006 The Apache Software Foundation.
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

import java.util.Map;

import javax.portlet.ResourceURL;

import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.spi.PortletURLProvider;

/**
 * Implementation of JSR-286 <code>ResourceURL</code>.
 *
 * @since 2.0
 */
public class ResourceURLImpl extends BaseURLImpl implements ResourceURL {
	public ResourceURLImpl(PortletContainer container,
	        PortletWindow portletWindow,
	        javax.servlet.http.HttpServletRequest servletRequest,
	        javax.servlet.http.HttpServletResponse servletResponse) {
			super(container,portletWindow,servletRequest,
				servletResponse,false,true);
	}

	public void setResourceID(String resourceID) {
		setParameter("resourceID", resourceID);
	}

	public String getCacheability() {
		String cacheLevel[] = getRenderParameters("CACHABILITY");
		if (cacheLevel == null)
			return ResourceURL.PAGE;
		else
			return cacheLevel[0];
	}
	
	public void setCacheability(String cacheLevel) {
		if (getCacheability().equals(ResourceURL.FULL) && (cacheLevel.equals(ResourceURL.PORTLET) || cacheLevel.equals(ResourceURL.PAGE) )){
			throw new IllegalStateException("Set wrong cacheLevel for ResourceURL");
		}
		else if (getCacheability().equals(ResourceURL.PORTLET) && cacheLevel.equals(ResourceURL.PAGE)){
			throw new IllegalStateException("Set wrong cacheLevel for ResourceURL");
		}
		setParameter("CACHABILITY", cacheLevel);
	}

	public void setParameter(String name, String value) {
	    if (name == null||value == null) {
	        throw new IllegalArgumentException(
	            "name and value must not be null");
	    }
	    //first make a get parameter
	    String[] tmp = this.servletRequest.getParameterValues(name);
	    if ( tmp== null){
	    	super.setParameter(name, value);
	    }
	    else{
	    	String[] values = new String[tmp.length+1];
	    	values[0] = value;
	    	System.arraycopy(tmp, 0, values, 1, tmp.length);
	    	super.setParameter(name, values);
	    }
	}

	public void setParameter(String name, String[] values) {
		if (name == null || values == null) {
	        throw new IllegalArgumentException(
	            "name and values must not be null");
	    }
	    //first make a get parameter
	    String[] tmp = this.servletRequest.getParameterValues(name);
	    if ( tmp== null){
	    	super.setParameter(name, values);
	    }
	    else{
	    	String[] tmpValues = new String[tmp.length+values.length];
	    	System.arraycopy(values, 0, tmpValues, 0, values.length);
	    	System.arraycopy(tmp, 0, tmpValues, values.length, tmp.length);
	    	super.setParameter(name, tmpValues);
	    }
	}

	public void setParameters(Map<String, String[]> parameters) {
		if (parameters == null){
			throw new IllegalArgumentException("parameter must not be null");
		}
		for (String name : parameters.keySet()) {
			setParameter(name, parameters.get(name));
		}
	}

	private String[] getRenderParameters(String name){
		int lenght = 0;
		String[] tmp1 = this.servletRequest.getParameterValues(name);
		if (tmp1!=null)
			lenght += tmp1.length;
		PortletURLProvider urlProvider = container.getRequiredContainerServices().getPortalCallbackService().getPortletURLProvider(super.servletRequest, portletWindow);
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
