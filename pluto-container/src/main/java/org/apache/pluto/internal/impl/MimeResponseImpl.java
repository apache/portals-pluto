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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.MimeResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.PortletEntity;
import org.apache.pluto.PortletWindow;
import org.apache.pluto.om.portlet.ExpirationCache;
import org.apache.pluto.om.portlet.Portlet;
import org.apache.pluto.om.portlet.Supports;
import org.apache.pluto.util.StringManager;

public class MimeResponseImpl extends PortletResponseImpl implements
		MimeResponse {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(MimeResponseImpl.class);
	
	private static final StringManager EXCEPTIONS = StringManager.getManager(
    		MimeResponseImpl.class.getPackage().getName());
	
	private class CacheControlImpl implements CacheControl {

		private String eTag;

		private int expirationTime;

		private boolean publicScope;

		private boolean cachedContent;

		public CacheControlImpl() {
			super();
		}

		public boolean useCachedContent() {
			return this.cachedContent;
		}

		public String getETag() {
			return this.eTag;
		}

		public int getExpirationTime() {
			return this.expirationTime;
		}

		public boolean isPublicScope() {
			return this.publicScope;
		}

		public void setETag(String eTag) {
			this.eTag = eTag;
		}

		public void setExpirationTime(int expirationTime) {
			this.expirationTime = expirationTime;
			MimeResponseImpl.super.setProperty(EXPIRATION_CACHE, String
					.valueOf(expirationTime));
		}

		public void setPublicScope(boolean publicScope) {
			this.publicScope = publicScope;
			MimeResponseImpl.super.setProperty(PUBLIC_SCOPE,
					publicScope ? PUBLIC_SCOPE : PRIVATE_SCOPE);
		}

		public void setUseCachedContent(boolean cachedContent) {
			this.cachedContent = cachedContent;
			MimeResponseImpl.super.setProperty(USE_CACHED_CONTENT,
					cachedContent ? Boolean.TRUE.toString() : null);
		}

	}

	private CacheControl cacheControl;

	public MimeResponseImpl(PortletContainer container,
            PortletWindow portletWindow,
            HttpServletRequest servletRequest,
            HttpServletResponse servletResponse) {
		
		super(container, portletWindow, servletRequest,
				servletResponse);
		this.cacheControl = new CacheControlImpl();
		PortletEntity portletEntity = portletWindow.getPortletEntity();
		Portlet portletDefinition = portletEntity.getPortletDefinition();
		ExpirationCache expirationCacheDD = portletDefinition
				.getExpirationCache();
		if (expirationCacheDD != null) {
			int expirationTime = expirationCacheDD.getExpirationTime();
			this.setProperty(EXPIRATION_CACHE, String.valueOf(expirationTime));
			String scope = expirationCacheDD.getScope();
			this.setProperty(CACHE_SCOPE, scope);
		}

	}
	
	@Override
    public void flushBuffer() throws IOException {
        getHttpServletResponse().flushBuffer();
    }
    
	public CacheControl getCacheControl() {
		return this.cacheControl;
	}
	
	@Override
	public void setProperty(String name, String value) {
		if (USE_CACHED_CONTENT.equals(name)) {
			this.cacheControl.setUseCachedContent(value != null);
		} else if (EXPIRATION_CACHE.equals(name)) {
			int expirationTime;
			try {
				expirationTime = Integer.parseInt(value);
			} catch (NumberFormatException e) {
				expirationTime = 0;
			}
			this.cacheControl.setExpirationTime(expirationTime);
		} else if (ETAG.equals(name)) {
			this.cacheControl.setETag(value);
		} else if (CACHE_SCOPE.equals(name)) {
			this.cacheControl.setPublicScope(PUBLIC_SCOPE.equals(value));
		} else {
			super.setProperty(name, value);
		}
	}
	
	@Override
	public String getCharacterEncoding() {
        return getHttpServletResponse().getCharacterEncoding();
    }
	
	@Override
	public Locale getLocale() {
        return getHttpServletResponse().getLocale();
    }
	
    /**
     * @see PortletResponseImpl#getOutputStream()
     * @see #getWriter()
     */
	public OutputStream getPortletOutputStream() throws IOException {
		if (getContentType() == null) {
			setContentType("text/html");
//            String message = EXCEPTIONS.getString("error.contenttype.null");
//            if (LOG.isWarnEnabled()) {
//            	LOG.warn("Current content type is not set.");
//            }
//            throw new IllegalStateException(message);
        }
        return super.getOutputStream();
	}
	
	
	public String getContentType(){
		return super.getContentType();
	}
	public void setContentType(String arg0){
		super.setContentType(arg0);
	}
	/**
     * @see PortletResponseImpl#getWriter()
     * @see #getPortletOutputStream()
     */
	@Override
    public PrintWriter getWriter() throws IOException {
        if (getContentType() == null) {
        	setContentType("text/html");
        }
        return super.getWriter();
    }
    
	@Override
    public boolean isCommitted() {
        return getHttpServletResponse().isCommitted();
    }
    
	@Override
    public void reset() {
        getHttpServletResponse().reset();
    }
    
	@Override
    public void resetBuffer() {
        getHttpServletResponse().resetBuffer();
    }
    
	public int getBufferSize(){
		return super.getBufferSize();
	}
	
	@Override
    public void setBufferSize(int size) {
    	getHttpServletResponse().setBufferSize(size);
    }
    
    // access to a limited set of HttpServletResponse methods ------------------
	
	@Override
	public void addDateHeader(String arg0, long arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.addProperty(arg0, Long.toString(arg1));
		}
		else
			super.addDateHeader(arg0, arg1);
	}
	
	@Override
	public void addHeader(String arg0, String arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.addProperty(arg0, arg1);
		}
		else
			super.addHeader(arg0, arg1);
	}
	
	@Override
	public void addIntHeader(String arg0, int arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.addProperty(arg0, Integer.toString(arg1));
		}
		else
			super.addIntHeader(arg0, arg1);
	}
	
	@Override
	public ServletOutputStream getOutputStream() throws IllegalStateException, IOException {
		if (super.isIncluded() || super.isForwarded()){
			return (ServletOutputStream)getPortletOutputStream();
		}
		else
			return super.getOutputStream();
	}

	@Override
	public void sendRedirect(String arg0) throws IOException {
		if (super.isIncluded() || super.isForwarded()){
			// no operation
		}
		else
			super.sendRedirect(arg0);
	}

	@Override
	public void setDateHeader(String arg0, long arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.setProperty(arg0, Long.toString(arg1));
		}
		else
			super.setDateHeader(arg0, arg1);
	}

	@Override
	public void setHeader(String arg0, String arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.setProperty(arg0, arg1);
		}
		else
			super.setHeader(arg0, arg1);
	}

	@Override
	public void setIntHeader(String arg0, int arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.setProperty(arg0, Integer.toString(arg1));
		}
		else
			super.setIntHeader(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0, String arg1) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.setProperty(arg1, Integer.toString(arg0));
		}
		else
			super.setStatus(arg0, arg1);
	}

	@Override
	public void setStatus(int arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.setProperty("STATUS", Integer.toString(arg0));
		}
		else
		super.setStatus(arg0);
	}
    
	public javax.portlet.PortletURL createRenderURL(){
		return super.createRenderURL();
	}
	public javax.portlet.PortletURL createActionURL(){
		return super.createActionURL();
	}
	public javax.portlet.ResourceURL createResourceURL(){
		return super.createResourceURL();
	}
	
    // Private Methods ---------------------------------------------------------
    
    /**
     * Checks if the specified content type is valid (supported by the portlet).
     * The specified content type should be a tripped mime type without any
     * character encoding suffix.
     * @param contentType  the content type to check.
     * @return true if the content type is valid, false otherwise.
     */
    protected boolean isValidContentType(String contentType) {
    	boolean valid = false;
    	
        Portlet portletDD = getPortletWindow().getPortletEntity()
        		.getPortletDefinition();
        for (Iterator it = portletDD.getSupports().iterator();
        		!valid && it.hasNext(); ) {
            
        	Supports supportsDD = (Supports) it.next();
            String supportedType = supportsDD.getMimeType();
            
            // Content type is supported by an exact match.
            if (supportedType.equals(contentType)) {
            	valid = true;
            }
            // The supported type contains a wildcard.
            else if (supportedType.indexOf("*") >= 0) {
            	
                int index = supportedType.indexOf("/");
                String supportedPrefix = supportedType.substring(0, index);
                String supportedSuffix = supportedType.substring(index + 1);
                
                index = contentType.indexOf("/");
                String typePrefix = contentType.substring(0, index);
                String typeSuffix = contentType.substring(index + 1);
                
                // Check if the prefixes match AND the suffixes match.
                if (supportedPrefix.equals("*") || supportedPrefix.equals(typePrefix)) {
                    if (supportedSuffix.equals("*") || supportedSuffix.equals(typeSuffix)) {
                        valid = true;
                    }
                }
            }
        }
        // Return the check result.
        return valid;
    }
}
