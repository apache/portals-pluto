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

package org.apache.pluto.core.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.core.InternalPortletWindow;
import org.apache.pluto.core.InternalPortletRequest;
import org.apache.pluto.core.InternalRenderRequest;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Implementation of the <code>javax.portlet.RenderRequest</code> interface.
 * 
 * @author <a href="mailto:ddewolf@apache.org">David H. DeWolf</a>
 * @author <a href="mailto:zheng@apache.org">ZHENG Zhong</a>
 */
public class RenderRequestImpl extends PortletRequestImpl
implements RenderRequest, InternalRenderRequest {
	
	/** Logger. */
    private static final Log LOG = LogFactory.getLog(RenderRequestImpl.class);
    
    
    // Private Member Variables ------------------------------------------------
    
    /** True if we are in an include call. */
    private boolean included = false;
    
    /** The parameters including parameters appended to the dispatching URI. */
    private Map parameters = null;
    
    /** The portlet preferences. */
    private PortletPreferences portletPreferences = null;
    
    
    // Constructors ------------------------------------------------------------
    
    public RenderRequestImpl(InternalPortletRequest request) {
        super(request);    
    }

    public RenderRequestImpl(PortletContainer container,
                             InternalPortletWindow internalPortletWindow,
                             HttpServletRequest servletRequest) {
        super(container, internalPortletWindow, servletRequest);
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Created render request for: " + internalPortletWindow);
        }
    }
    
    
    // RenderRequest Impl ------------------------------------------------------
    
    public PortletPreferences getPreferences() {
        if (portletPreferences == null) {
            portletPreferences = new PortletPreferencesImpl(
            		getPortletContainer(),
            		getInternalPortletWindow(),
            		this,
            		Constants.METHOD_RENDER);
        }
        return portletPreferences;
    }
    
    
    /**
     * Checks the included flag and returns the content type. If the included
     * flag is set to true, this method returns null.
     */
    public String getContentType() {
        if (included) {
            return null;
        } else {
        	return super.getContentType();
        }
    }
    
    /**
     * Checks the included flag and returns the content length. If the included
     * flag is set to true, this method returns 0.
     */
    public int getContentLength() {
        if (included) {
            return 0;
        } else {
        	return super.getContentLength();
        }
    }
    
    /**
     * Checks the included flag and returns the reader to this rende response.
     * If the included flag is set to true, this method returns null.
     */
    public BufferedReader getReader()
    throws UnsupportedEncodingException, IOException {
        if (included) {
            return null;
        } else {
        	return super.getReader();
        }
    }
    
    /**
     * Checks the included flag and returns the input stream to this render
     * response. If the included flag is set to true, this method returns null.
     */
    public ServletInputStream getInputStream()
    throws IOException {
        if (included) {
            return null;
        } else {
        	return super.getInputStream();
        }
    }
    
    
    // PortletRequestImpl Overwriting ------------------------------------------
    
    protected Map baseGetParameterMap() {
    	if (included && parameters != null) {
    		super.setBodyAccessed();
    		return parameters;
    	} else {
    		return super.baseGetParameterMap();
    	}
    }
    
    
    // InternalRenderRequest Impl ----------------------------------------------
    
    public void setIncluded(boolean included) {
    	this.included = included;
        if (!included) {
        	this.parameters = null;
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Render request's included mode: " + included);
        }
    }

    public boolean isIncluded() {
        return included;
    }
    
    public void setAppendedParameters(Map appendedParameters)
    throws IllegalStateException {
    	if (!included) {
    		throw new IllegalStateException("Parameters cannot be appended to "
    				+ "render request which is not included in a dispatch.");
    	}
    	if (appendedParameters != null && !appendedParameters.isEmpty()) {
    		// Copy all the original render parameters.
    		parameters = new HashMap(super.getParameterMap());
    		// Put appended parameters to the render parameter map.
    		// The original render parameters should not be overwritten.
    		appendParameters(parameters, appendedParameters);
    		// Log the new render parameter map.
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("New parameter map: " + parameters.toString());
    		}
    	} else {
    		if (LOG.isDebugEnabled()) {
    			LOG.debug("No parameters appended to the included request.");
    		}
    	}
    }
    
    
    // Private Methods ---------------------------------------------------------
    
    /**
     * Appends key-value pairs in one parameter map (A) to another parameter
     * map (B). If a key from map A does not exist in map B, the key-value pair
     * is added to map B directly. Otherwise, value from map A and value from
     * map B are merged into a single string array, and added to map B.
     * @param parameters  the target parameter map (map B).
     * @param appended  the appended parameter map (map A).
     */
    private void appendParameters(Map parameters, Map appended) {
    	for (Iterator it = appended.keySet().iterator(); it.hasNext(); ) {
    		String key = (String) it.next();
    		// If the parameter name (key) does not exist, put it to map.
    		if (!parameters.containsKey(key)) {
    			parameters.put(key, appended.get(key));
    		}
    		// Otherwise, merge the two value arrays.
    		else {
    			String[] originalValues = (String[]) parameters.get(key);
    			String[] appendedValues = (String[]) appended.get(key);
    			List values = new ArrayList();
    			// Appended parameter values first.
    			if (appendedValues != null) {
    				for (int i = 0; i < appendedValues.length; i++) {
    					values.add(appendedValues[i]);
    				}
    			}
    			// Then original parameter values.
    			if (originalValues != null) {
    				for (int i = 0; i < originalValues.length; i++) {
    					values.add(originalValues[i]);
    				}
    			}
    			parameters.put(key,
    					(String[]) values.toArray(new String[values.size()]));
    		}
    	}
    }
    
}
