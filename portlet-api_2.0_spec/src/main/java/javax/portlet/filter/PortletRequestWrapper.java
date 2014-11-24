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

import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortalContext;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;

/**
 * The <code>PortletRequestWrapper</code> provides a convenient 
 * implementation of the <code>PortletRequest</code> interface 
 * and is extended by other request wrappers.
 * This class implements the Wrapper or Decorator pattern. 
 * Methods default to calling through to the wrapped request object.
 *
 * @since 2.0
 * @see PortletRequest
 */
public class PortletRequestWrapper implements PortletRequest {

    PortletRequest request;
    
    /** 
     * Require having a request for constructing
     * the wrapper.
     *
     */
    private PortletRequestWrapper() {
    }
    
    
    /**
     * Creates an <code>PortletRequest</code> adaptor 
     * wrapping the given request object.
     * 
     * @param request  the portlet request to wrap
     * @throws java.lang.IllegalArgumentException if the request is <code>null</code>
     */
    public PortletRequestWrapper(PortletRequest request) {
    	if ( request == null)
    		throw new java.lang.IllegalArgumentException("Request is null");

        this.request = request;
    }

    /**
     * The default behavior of this method is to call 
     * <code>getAttribute(String name)</code> on the wrapped request object.
     */
    public Object getAttribute(String name) {
        return request.getAttribute(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getAttributeNames()</code> on the wrapped request object.
     */
    public Enumeration<String> getAttributeNames() {
        return request.getAttributeNames();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getAuthType()</code> on the wrapped request object.
     */
    public String getAuthType() {
        return request.getAuthType();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getContextPath()</code> on the wrapped request object.
     */
    public String getContextPath() {
        return request.getContextPath();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getLocale()</code> on the wrapped request object.
     */
    public Locale getLocale() {
        return request.getLocale();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getLocales()</code> on the wrapped request object.
     */
    public Enumeration<Locale> getLocales() {
        return request.getLocales();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getParameter(String name)</code> on the wrapped request object.
     */
    public String getParameter(String name) {
        return request.getParameter(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getParameterMap()</code> on the wrapped request object.
     */
    public Map<String, String[]> getParameterMap() {
        return request.getParameterMap();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getParameterNames()</code> on the wrapped request object.
     */
    public Enumeration<String> getParameterNames() {
        return request.getParameterNames();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getParameterValues(name)</code> on the wrapped request object.
     */
    public String[] getParameterValues(String name) {
        return request.getParameterValues(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortalContext()</code> on the wrapped request object.
     */
    public PortalContext getPortalContext() {
        return request.getPortalContext();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletMode()</code> on the wrapped request object.
     */
    public PortletMode getPortletMode() {
        return request.getPortletMode();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletSession()</code> on the wrapped request object.
     */
    public PortletSession getPortletSession() {
        return request.getPortletSession();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPortletSession(create)</code> on the wrapped request object.
     */
    public PortletSession getPortletSession(boolean create) {
        return request.getPortletSession(create);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPreferences()</code> on the wrapped request object.
     */
    public PortletPreferences getPreferences() {
        return request.getPreferences();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getProperteis(name)</code> on the wrapped request object.
     */
    public Enumeration<String> getProperties(String name) {
        return request.getProperties(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getProperty(name)</code> on the wrapped request object.
     */
    public String getProperty(String name) {
        return request.getProperty(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>getPropertyNames()</code> on the wrapped request object.
     */
    public Enumeration<String> getPropertyNames() {
        return request.getPropertyNames();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getRemoteUser()</code> on the wrapped request object.
     */
    public String getRemoteUser() {
        return request.getRemoteUser();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getRequestedSessionId()</code> on the wrapped request object.
     */
    public String getRequestedSessionId() {
        return request.getRequestedSessionId();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getResponseContentType()</code> on the wrapped request object.
     */
    public String getResponseContentType() {
        return request.getResponseContentType();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getResponseContentTypes()</code> on the wrapped request object.
     */
    public Enumeration<String> getResponseContentTypes() {
        return request.getResponseContentTypes();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getScheme()</code> on the wrapped request object.
     */
    public String getScheme() {
        return request.getScheme();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getServerName()</code> on the wrapped request object.
     */
    public String getServerName() {
        return request.getServerName();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getServerPort()</code> on the wrapped request object.
     */
    public int getServerPort() {
        return request.getServerPort();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getUserPrincipal()</code> on the wrapped request object.
     */
    public Principal getUserPrincipal() {
        return request.getUserPrincipal();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getWindowId()</code> on the wrapped request object.
     */
    public String getWindowID() {
        return request.getWindowID();
    }

    /**
     * The default behavior of this method is to call 
     * <code>getWindowState()</code> on the wrapped request object.
     */
    public WindowState getWindowState() {
        return request.getWindowState();
    }

    /**
     * The default behavior of this method is to call 
     * <code>isPortletModeAllowed(mode)</code> on the wrapped request object.
     */
    public boolean isPortletModeAllowed(PortletMode mode) {
        return request.isPortletModeAllowed(mode);
    }

    /**
     * The default behavior of this method is to call 
     * <code>isRequestedSessionIdValid()</code> on the wrapped request object.
     */
    public boolean isRequestedSessionIdValid() {
        return request.isRequestedSessionIdValid();
    }

    /**
     * The default behavior of this method is to call 
     * <code>isSecure()</code> on the wrapped request object.
     */
    public boolean isSecure() {
        return request.isSecure();
    }

    /**
     * The default behavior of this method is to call 
     * <code>isUserInRole(role)</code> on the wrapped request object.
     */
    public boolean isUserInRole(String role) {
        return request.isUserInRole(role);
    }

    /**
     * The default behavior of this method is to call 
     * <code>isWindowStateAllowed(state)</code> on the wrapped request object.
     */
    public boolean isWindowStateAllowed(WindowState state) {
        return request.isWindowStateAllowed(state);
    }

    /**
     * The default behavior of this method is to call 
     * <code>removeAttribute(name)</code> on the wrapped request object.
     */
    public void removeAttribute(String name) {
        request.removeAttribute(name);
    }

    /**
     * The default behavior of this method is to call 
     * <code>setAttribute(name, o)</code> on the wrapped request object.
     */
    public void setAttribute(String name, Object o) {
        request.setAttribute(name, o);
    }

    /**
     * Return the wrapped request object.
     * 
     * @return the wrapped request
     */
    public PortletRequest getRequest() {
        return request;
    }

    /**
     * Sets the request object being wrapped.
     * 
     * @param request the request to set
     * @throws java.lang.IllegalArgumentException   if the request is null.
     */
    public void setRequest(PortletRequest request) {
    	if ( request == null)
    		throw new java.lang.IllegalArgumentException("Request is null");

    	this.request = request;
    }

    /**
     *  The default behavior of this method is to call 
     * <code>getCookies()</code> on the wrapped request object.
     */
    public Cookie[] getCookies() {
    	return request.getCookies();
    }

    /**
     *  The default behavior of this method is to call 
     * <code>getPrivateParameterMap()</code> on the wrapped request object.
     */
	public Map<String, String[]> getPrivateParameterMap() {
		return request.getPrivateParameterMap();
	}

    /**
     *  The default behavior of this method is to call 
     * <code>getPublicParameterMap()</code> on the wrapped request object.
     */
	public Map<String, String[]> getPublicParameterMap() {
		return request.getPublicParameterMap();
	}
}
