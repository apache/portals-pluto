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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.portlet.RenderRequest;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.Constants;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.internal.InternalPortletRequest;
import org.apache.pluto.internal.InternalRenderRequest;

/**
 * Implementation of the <code>javax.portlet.RenderRequest</code> interface.
 * 
 */
public class RenderRequestImpl extends PortletRequestImpl
                implements RenderRequest, InternalRenderRequest 
{
    private static final Log LOG = LogFactory.getLog(RenderRequestImpl.class);
       
    public RenderRequestImpl(InternalPortletRequest request) 
    {
        super(request);    
    }

    public RenderRequestImpl(PortletContainer container,
                             PortletWindow portletWindow,
                             HttpServletRequest servletRequest) 
    {
        super(container, portletWindow, servletRequest);
        if (LOG.isDebugEnabled()) 
        {
        	LOG.debug("Created render request for: " + portletWindow);
        }
    }

    protected Integer getRequestMethod()
    {
        return Constants.METHOD_RENDER; 
    }
    
    public String getMethod() 
    {
        return "GET";
    }
    
    // Included HttpServletRequest (Limited) Impl ------------------------------
    
    public String getCharacterEncoding() 
    {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getCharacterEncoding();
    }
    
    public void setCharacterEncoding(String encoding)
    throws UnsupportedEncodingException 
    {
        if (!super.isIncluded() && !super.isForwarded()) 
        {
        	super.setCharacterEncoding(encoding);
        }
    }        

	public String getETag() 
	{
		// TODO Return ETag
		return null;
	}
	
	public String getLifecyclePhase() 
	{
		return RENDER_PHASE;
	}
	
	/* TODO: DST: not sure of the requirements for these */
    /**
     * Checks the included flag and returns the content type. If the included
     * flag is set to true, this method returns null.
     */
    public String getContentType() 
    {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getContentType();
    }
    
    /**
     * Checks the included flag and returns the content length. If the included
     * flag is set to true, this method returns 0.
     */
    public int getContentLength() 
    {
        return (super.isIncluded() || super.isForwarded()) ? 0 : super.getContentLength();
    }
	
    /**
     * Checks the included flag and returns the reader to this rende response.
     * If the included flag is set to true, this method returns null.
     */
    public BufferedReader getReader()
    throws UnsupportedEncodingException, IOException 
    {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getReader();
    }

    /**
     * Checks the included flag and returns the input stream to this render
     * response. If the included flag is set to true, this method returns null.
     */
    public ServletInputStream getInputStream() throws IOException 
    {
        return (super.isIncluded() || super.isForwarded()) ? null : super.getInputStream();
    }
    
}
