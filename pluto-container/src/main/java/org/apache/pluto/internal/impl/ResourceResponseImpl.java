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
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.PortalContext;
import javax.portlet.ResourceResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.pluto.PortletContainer;
import org.apache.pluto.internal.InternalPortletWindow;
import org.apache.pluto.internal.InternalResourceResponse;
import org.apache.pluto.spi.PortalCallbackService;
import org.apache.pluto.util.StringManager;

public class ResourceResponseImpl extends StateAwareResponseImpl
implements ResourceResponse, InternalResourceResponse {
	
	/** Logger. */
	private static final Log LOG = LogFactory.getLog(ResourceResponseImpl.class);
	
	private static final StringManager EXCEPTIONS = StringManager.getManager(
    		ResourceResponseImpl.class.getPackage().getName());

    private PortalCallbackService callback;
    private PortalContext context;

    /** The current content type. */
    private String currentContentType = null;

    public ResourceResponseImpl(PortletContainer container,
                              InternalPortletWindow internalPortletWindow,
                              HttpServletRequest servletRequest,
                              HttpServletResponse servletResponse) {
        super(container, internalPortletWindow, servletRequest,
              servletResponse);
        context = container.getRequiredContainerServices().getPortalContext();
        callback = container.getRequiredContainerServices().getPortalCallbackService();
    }


	public CacheControl getCacheControl() {
		// TODO Auto-generated method stub
//		return null;
		throw new UnsupportedOperationException("This method needs to be implemented");
	}

	public OutputStream getPortletOutputStream() throws IOException {
		if (currentContentType == null) {
            String message = EXCEPTIONS.getString("error.contenttype.null");
            if (LOG.isWarnEnabled()) {
            	LOG.warn("Current content type is not set.");
            }
            throw new IllegalStateException(message);
        }
        return super.getOutputStream();
	}


	public void setTitle(String arg0) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("This method needs to be implemented");		
	}
	
	/////////////////////////////////////////////////////////////////////////
	//////neu
	/////////////////////////////////////////////////////////////////////////

	public String getContentType() {
        return super.getHttpServletResponse().getContentType();
    }
	
	public String getCharacterEncoding() {
        return getHttpServletResponse().getCharacterEncoding();
    }
	
	/**
     * @see PortletResponseImpl#getWriter()
     * @see #getPortletOutputStream()
     */
    @Override
    public PrintWriter getWriter() throws IOException, IllegalStateException {
        if (currentContentType == null) {
            String message = EXCEPTIONS.getString("error.contenttype.null");
            if (LOG.isWarnEnabled()) {
            	LOG.warn("Current content type is not set.");
            }
            throw new IllegalStateException(message);
        }
        return super.getWriter();
    }
	
	public Locale getLocale() {
        return getHttpServletRequest().getLocale();
    }

    @Override
    public void setBufferSize(int size) {
    	super.getHttpServletResponse().setBufferSize(size);
    }

    @Override
    public int getBufferSize() {
        return this.getHttpServletResponse().getBufferSize();
    }

    @Override
    public void flushBuffer() throws IOException {
        getHttpServletResponse().flushBuffer();
    }

    @Override
    public void resetBuffer() {
        getHttpServletResponse().resetBuffer();
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
	public ServletOutputStream getOutputStream() throws IllegalStateException, IOException {
		if (super.isIncluded() || super.isForwarded()){
			return (ServletOutputStream)getPortletOutputStream();
		}
		else
			return super.getOutputStream();
	}


	@Override
	public void addCookie(Cookie arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else if (super.isForwarded()){
			super.addProperty(arg0);
		}
		else
			super.addCookie(arg0);
	}


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
	public boolean containsHeader(String arg0) {
		if (super.isIncluded() || super.isForwarded()){
			return false;
		}
		return super.containsHeader(arg0);
	}

	// Included HttpServletResponse (Limited) Impl -----------------------------
    
    @Override
    public String encodeRedirectUrl(String url) {
    	if (super.isIncluded() || super.isForwarded()) {
    		return null;
    	} else {
    		return super.encodeRedirectUrl(url);
    	}
    }
    
    @Override
    public String encodeRedirectURL(String url) {
    	if (super.isIncluded() || super.isForwarded()) {
    		return null;
    	} else {
    		return super.encodeRedirectURL(url);
    	}
    }
	
	@Override
	public void sendError(int arg0, String arg1) throws IOException {
		if (super.isIncluded() || super.isForwarded()){
			// no operation
		}
		else
			super.sendError(arg0, arg1);
	}


	@Override
	public void sendError(int arg0) throws IOException {
		if (super.isIncluded() || super.isForwarded()){
			// no operation
		}
		else
			super.sendError(arg0);
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


	@Override
	public void setCharacterEncoding(String arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setCharacterEncoding(arg0);
	}


	@Override
	public void setContentLength(int arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setContentLength(arg0);
	}


	@Override
	public void setLocale(Locale arg0) {
		if (super.isIncluded()){
			//no operation
		}
		else
			super.setLocale(arg0);
	}
}
