/*  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

/*
 * This source code implements specifications defined by the Java
 * Community Process. In order to remain compliant with the specification
 * DO NOT add / change / or delete method signatures!
 */

package javax.portlet.filter;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.portlet.CacheControl;
import javax.portlet.PortletMode;
import javax.portlet.PortletURL;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceURL;

/**
 * The <code>RenderResponseWrapper</code> provides a convenient 
 * implementation of the <code>RenderResponse</code> interface 
 * that can be subclassed by developers wishing to adapt the response.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see RenderResponse
 */

public class RenderResponseWrapper extends PortletResponseWrapper implements RenderResponse {

    RenderResponse response;
    
    /**
     * Creates an <code>RenderResponse</code> adaptor 
     * wrapping the given response object.
     * 
     * @param response  the event response to wrap
     * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
     */
    public RenderResponseWrapper(RenderResponse response) {
    	super(response);
    	this.response = response;
    }

    /**
     * The default behavior of this method is to call 
     * <code>flushBuffer()</code> on the wrapped response object.
     */ 
    public void flushBuffer() throws IOException {
        response.flushBuffer();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getBufferSize()</code> on the wrapped response object.
     */
    public int getBufferSize() {
        return response.getBufferSize();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getCharacterEncoding()</code> on the wrapped response object.
     */
    public String getCharacterEncoding() {
        return response.getCharacterEncoding();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getContentType()</code> on the wrapped response object.
     */
    public String getContentType() {
        return response.getContentType();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getLocale()</code> on the wrapped response object.
     */
    public Locale getLocale() {
        return response.getLocale();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletOutputStream()</code> on the wrapped response object.
     */
    public OutputStream getPortletOutputStream() throws IOException {
        return response.getPortletOutputStream();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getWriter()</code> on the wrapped response object.
     */
    public PrintWriter getWriter() throws IOException {
        return response.getWriter();
    }

    /**
     * The default behavior of this method is to call 
     * <code>isCommitted()</code> on the wrapped response object.
     */
    public boolean isCommitted() {
        return response.isCommitted();
    }

    /**
     * The default behavior of this method is to call 
     * <code>reset()</code> on the wrapped response object.
     */
    public void reset() {
        response.reset();
    }

    /**
     * The default behavior of this method is to call 
     * <code>resetBuffer()</code> on the wrapped response object.
     */
    public void resetBuffer() {
        response.resetBuffer();
    }

    /**
     * The default behavior of this method is to call 
     * <code>setBufferSize(size)</code> on the wrapped response object.
     */
    public void setBufferSize(int size) {
        response.setBufferSize(size);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setContentType(type)</code> on the wrapped response object.
     */
    public void setContentType(String type) {
        response.setContentType(type);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setTitle(title)</code> on the wrapped response object.
     */
    public void setTitle(String title) {
        response.setTitle(title);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getCacheControl()</code> on the wrapped response object.
     */
    public CacheControl getCacheControl() {
        return response.getCacheControl();
    }

    /**
     *  The default behavior of this method is to call 
     * <code>setNextPossiblePortletModes()</code> on the wrapped response object.
     */
    public void setNextPossiblePortletModes(Collection<PortletMode> portletModes) {
        response.setNextPossiblePortletModes(portletModes);
    }

    /**
     * Return the wrapped response object.
     * 
     * @return the wrapped response
     */
    public RenderResponse getResponse() {
        return response;
    }

    /**
     * Sets the response object being wrapped.
     * 
     * @param response the response to set
     * @throws java.lang.IllegalArgumentException   if the response is null.
     */
    public void setResponse(RenderResponse response) {
	    	if ( response == null)
	    		throw new java.lang.IllegalArgumentException("Response is null");

	    	this.response = response;
    }

    /**
     *  The default behavior of this method is to call 
     * <code>createActionURL()</code> on the wrapped response object.
     */
	public PortletURL createActionURL() throws IllegalStateException {
		return response.createActionURL();
	}

    /**
     *  The default behavior of this method is to call 
     * <code>createRenderURL()</code> on the wrapped response object.
     */
	public PortletURL createRenderURL() throws IllegalStateException {
		return response.createRenderURL();
	}

    /**
     *  The default behavior of this method is to call 
     * <code>createResourceURL()</code> on the wrapped response object.
     */
	public ResourceURL createResourceURL() throws IllegalStateException {
		return response.createResourceURL();
	}



}
