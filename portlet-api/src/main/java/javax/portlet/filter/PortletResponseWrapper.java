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

import javax.portlet.PortletResponse;
import javax.servlet.http.Cookie;

/**
 * The <code>PortletResponseWrapper</code> provides a convenient 
 * implementation of the <code>PortletResponse</code> interface 
 * and is extended by other response wrappers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped response object.
 *
 * @since 2.0
 * @see PortletResponse
 */
public class PortletResponseWrapper implements PortletResponse {

		PortletResponse response;
	    
	    /** 
	     * Require having a response for constructing
	     * the wrapper.
	     *
	     */
	    private PortletResponseWrapper() {
	    }
	    
	    /**
	     * Creates an <code>ActionResponse</code> adaptor 
	     * wrapping the given response object.
	     * 
	     * @param response  the action response to wrap
	     * @throws java.lang.IllegalArgumentException if the response is <code>null</code>
	     */
	    public PortletResponseWrapper(PortletResponse response) {
	    	if ( response == null)
	    		throw new java.lang.IllegalArgumentException("Response is null");

	        this.response = response;
	    }

	    /**
	     * The default behavior of this method is to call 
	     * <code>addProperty(key, value)</code> on the wrapped response object.
	     */
	    public void addProperty(String key, String value) {
	        response.addProperty(key, value);
	    }

	    /**
	     * The default behavior of this method is to call 
	     * <code>encodeURL(path)</code> on the wrapped response object.
	     */
	    public String encodeURL(String path) {
	        return response.encodeURL(path);
	    }

	    /**
	     * The default behavior of this method is to call 
	     * <code>getNamespace()</code> on the wrapped response object.
	     */
	    public String getNamespace() {
	        return response.getNamespace();
	    }

	    /**
	     * The default behavior of this method is to call 
	     * <code>setProperty(key, value)</code> on the wrapped response object.
	     */
	    public void setProperty(String key, String value) {
	        response.setProperty(key, value);
	    }

	    /**
	     * Return the wrapped response object.
	     * 
	     * @return the wrapped response
	     */
	    public PortletResponse getResponse() {
	        return response;
	    }

	    /**
	     * Sets the response object being wrapped.
	     * 
	     * @param response the response to set
	     * @throws java.lang.IllegalArgumentException   if the response is null.
	     */
	    public void setResponse(PortletResponse response) {
	    	if ( response == null)
	    		throw new java.lang.IllegalArgumentException("Response is null");

	        this.response = response;
	    }

	    /**
	     *  The default behavior of this method is to call 
	     * <code>addProperty()</code> on the wrapped response object.
	     */
	    public void addProperty(String key, org.w3c.dom.Element element) {
	        response.addProperty(key, element);
	    }

	    /**
	     *  The default behavior of this method is to call 
	     * <code>createElement()</code> on the wrapped response object.
	     */
	    public org.w3c.dom.Element createElement(String tagName) {
	        return response.createElement(tagName);
	    }

	    /**
	     *  The default behavior of this method is to call 
	     * <code>addProperty()</code> on the wrapped response object.
	     */
	    public void addProperty(Cookie cookie) {
	        response.addProperty(cookie);
	    }

}
