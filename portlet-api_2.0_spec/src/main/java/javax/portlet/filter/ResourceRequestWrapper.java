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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.portlet.ResourceRequest;

/**
 * The <code>ResourceRequestWrapper</code> provides a convenient 
 * implementation of the <code>ResourceRequest</code> interface 
 * that can be subclassed by developers wishing to adapt the request.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 *
 * @since 2.0
 * @see ResourceRequest
 */
public class ResourceRequestWrapper extends PortletRequestWrapper implements ResourceRequest {

    ResourceRequest request;

    /**
     * Creates an <code>ResourceRequest</code> adaptor 
     * wrapping the given request object.
     * 
     * @param request  the resource request to wrap
     * @throws java.lang.IllegalArgumentException if the request is <code>null</code>
     */
    public ResourceRequestWrapper(ResourceRequest request) {
    	super(request);
    	this.request = request;
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletInputStream()</code> on the wrapped request object.
     */
    public InputStream getPortletInputStream() throws IOException {
        return request.getPortletInputStream();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getReader()</code> on the wrapped request object.
     */
    public BufferedReader getReader() throws UnsupportedEncodingException,
            IOException {
        return request.getReader();
    }

    /**
     * The default behavior of this method is to call 
     * <code>setCharacterEncoding(String enc)</code> 
     * on the wrapped request object.
     */
    public void setCharacterEncoding(String enc)
            throws UnsupportedEncodingException {
       request.setCharacterEncoding(enc);
    }
    

    /**
     * Return the wrapped request object.
     * 
     * @return the wrapped request
     */
    public ResourceRequest getRequest() {
        return request;
    }

    /**
     * Sets the request object being wrapped.
     * 
     * @param request the request to set
     * @throws java.lang.IllegalArgumentException   if the request is null.
     */
    public void setRequest(ResourceRequest request) {
    	if ( request == null)
    		throw new java.lang.IllegalArgumentException("Request is null");

    	this.request = request;
    }

    /**
     * The default behavior of this method is to call 
     * <code>getCharacterEncoding()</code> on the wrapped request object.
     */
    public String getCharacterEncoding() {      
        return request.getCharacterEncoding();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getContentLength()</code> on the wrapped request object.
     */
    public int getContentLength() {
        return request.getContentLength();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getContentType()</code> on the wrapped request object.
     */
    public String getContentType() {
        return request.getContentType();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getETag()</code> on the wrapped request object.
     */
    public String getETag() {
        return request.getETag();
    }

    /**
     *  The default behavior of this method is to call 
     * <code>getMethod()</code> on the wrapped request object.
     */
    public String getMethod() {
        return request.getMethod();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getResourceID()</code> on the wrapped request object.
     */
    public String getResourceID() {
        return request.getResourceID();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPrivateRenderParameterMap()</code> on the wrapped request object.
     */
	public Map<String, String[]> getPrivateRenderParameterMap() {
		return request.getPrivateParameterMap();
	}

    /**
     *  The default behavior of this method is to call 
     * <code>getCacheability()</code> on the wrapped response object.
     */
    public String getCacheability() {
        return request.getCacheability();
    }
    

}
