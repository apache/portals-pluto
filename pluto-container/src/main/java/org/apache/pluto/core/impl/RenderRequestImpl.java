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
    
    /**
     * FIXME: portlet preference method ID!
     */
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
    
    
    // InternalRenderRequest Impl ----------------------------------------------
    
    public void setIncluded(boolean included) {
        this.included = included;
    }

    public boolean isIncluded() {
        return included;
    }
    
}
